package rpc.proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {

    public static void main(String[] args) {

        HiService hiService = new HiServiceImpl();
        HiService proxyInstance = (HiService) Proxy.newProxyInstance(hiService.getClass().getClassLoader(), hiService.getClass().getInterfaces(), new Handler(hiService));

        hiService.say("hi");
        proxyInstance.say("hello world");


    }

}
