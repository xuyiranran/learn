package learn_netty.bioecho;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio echo 服务端代码
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {

        //创建监听本地端口的服务
        ServerSocket serverSocket = new ServerSocket(9000);

        //监听客户端的连接(阻塞方法)
        Socket socket = serverSocket.accept();

        //通过socket套接字获取输入输出流
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter printWriter = new PrintWriter(outputStream);

        while (true) {
            //读取客户端数据
            String line = bufferedReader.readLine();
            if (line != null) {
                System.out.println("client:" + line);
                //响应客户端数据
                printWriter.println(line.toUpperCase());
                printWriter.flush();
            }
        }

    }


}
