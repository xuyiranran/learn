package rpc.simple_rpc;

public class RpcConsumer {

    public static void main(String[] args) throws Exception{


        HelloService service = RPCFramework.refer(HelloService.class, "127.0.0.1", 9000);
        for (int i = 0; i < 3; i ++) {
            String hello = service.sayHello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }


    }

}
