package learn_netty.nioecho;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * nio echo服务端代码
 */
public class EchoServer {


    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //注册channel为非阻塞
        serverSocketChannel.configureBlocking(false);
        //非阻塞io的核心Selector选择器
        Selector selector = Selector.open();
        serverSocketChannel.bind(new InetSocketAddress(9000));

        //将severSocketChannel accept事件注册到selector上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int readyCount = selector.select();
            selector.keys();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
            while (selectionKeyIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeyIterator.next();
                selectionKeyIterator.remove();

                //连接事件就绪
                if (selectionKey.isAcceptable()) {
                    System.out.println("acceptable");
                    ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);
                    SelectionKey clientKey = socketChannel.register(selector, socketChannel.validOps());
                }
                //读事件就绪
                if (selectionKey.isReadable()) {
                    System.out.println("readable");
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                    clientChannel.read(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array()));
                }
                //写事件就绪
                if (selectionKey.isWritable()) {
                    System.out.println("writable");
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                    byteBuffer.put("hello".getBytes()).flip();
                    clientChannel.write(byteBuffer);
                }
            }

        }


    }

}
