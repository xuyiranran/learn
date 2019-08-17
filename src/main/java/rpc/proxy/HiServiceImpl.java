package rpc.proxy;

public class HiServiceImpl implements HiService {
    @Override
    public void say(String info) {

        System.out.println(info);

    }
}
