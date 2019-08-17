package rpc.simple_rpc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.IOUtils;
import com.google.common.collect.Maps;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class RPCFramework {


    public static Map<String, Object> registerService = Maps.newConcurrentMap();

    //服务注册
    public static void registerService(String serviceName, Object serviceInterface) {
        registerService.putIfAbsent(serviceName, serviceInterface);
    }


    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception {
        if (interfaceClass == null)
            throw new IllegalArgumentException("Interface class == null");
        if (!interfaceClass.isInterface())
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        if (host == null || host.length() == 0)
            throw new IllegalArgumentException("Host == null!");
        if (port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
                Socket socket = new Socket(host, port);
                try {
                    PrintWriter output = new PrintWriter(socket.getOutputStream());
                    BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
                    try {
                        RequestPojo requestPojo = new RequestPojo();
                        requestPojo.setMethodName(method.getName());
                        requestPojo.setServiceName(interfaceClass.getName());
                        requestPojo.setParameters(arguments);
                        Class<?>[] types = new Class[arguments.length];
                        for (int i = 0; i < arguments.length; i++) {
                            types[i] = arguments[i].getClass();
                        }
                        requestPojo.setParameterTypes(types);
                        System.out.println("客户端发送的数据:" + JSONObject.toJSONString(requestPojo));
                        output.println(JSONObject.toJSONString(requestPojo));
                        output.flush();
                        output.println();
                        String data = "";
                        byte[] buffer = new byte[5024];
                        int len = 0;
                        while ((len = in.read(buffer)) != -1) {
                            data = new String(buffer, 0, len);
                        }
                        System.out.println("发送的数据" + data);
                        try {
                            return (T) JSON.parse(data);
                        } finally {
                            in.close();
                        }
                    } finally {
                        output.close();
                    }
                } finally {
                    socket.close();
                }
            }
        });
    }

    //启动服务器
    public static void start(int port) throws Exception {

        //监听指定端口
        ServerSocket server = new ServerSocket(port);
        for (; ; ) {
            Socket socket = server.accept();
            InputStream in = socket.getInputStream();
            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    //协议解析(这里简单实用json协议解析)
                    String data = "";
//                    byte[] buffer = new byte[1024];
//                    int len = 0;
//                    while ((len = in.read(buffer)) != -1) {
//                        data = new String(buffer, 0, len);
//                    }
                    data = IOUtils.readAll(new InputStreamReader(in));
                    System.out.println("获取到的数据" + data);
                    RequestPojo requestPojo = (RequestPojo) JSON.parse(data);
                    if (requestPojo != null) {
                        //解析主要执行的方法
                        String serviceNmae = requestPojo.getServiceName();
                        String methodName = requestPojo.getMethodName();
                        Class<?>[] parameterTypes = requestPojo.getParameterTypes();
                        Object[] parameters = requestPojo.getParameters();
                        Object invokeObject = registerService.getOrDefault(serviceNmae, null);
                        if (invokeObject == null) {
                            System.out.println("服务注册中心没有注册改服务");
                        }
                        Method method = invokeObject.getClass().getMethod(methodName, parameterTypes);
                        Object result = method.invoke(invokeObject, parameters);
                        //返回结果 todo
                        outputStream.write(JSONObject.toJSONString(result).getBytes());
                        outputStream.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //结果返回
            }).start();
        }
    }
}
