package learn_netty.nioecho;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class DiscardClient {


    public static void main(String[] args) throws Exception{

        SocketChannel socketChannel=SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",9000));
        System.out.println("client 链接");


        for (int i = 0; i < 3; i++) {
            ByteBuffer byteBuffer=ByteBuffer.allocate(256);
            byteBuffer.put("client".getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
        }
        System.out.println("end");

    }

}
