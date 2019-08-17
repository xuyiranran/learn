package rpc.simple_rpc;

public class RPCMainApp {

    public static void main(String[] args) {

        HelloService helloService=new HelloServiceImpl();
        RPCFramework.registerService("helloService",helloService);

        try {
            RPCFramework.start(9000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
