package rpc.simple_rpc;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String info) {
        return "hello" + info;
    }
}
