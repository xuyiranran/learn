package learn_netty.nioecho;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * nio 客户端代码
 */
public class EchoClient {

    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9000));

        for (int i = 0; i < 3; i++) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            byteBuffer.put("hello".getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            Thread.sleep(3000);
        }

    }
}
