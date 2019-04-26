package learn_netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.net.InetAddress;

public class ByteBufApp {

    public static void main(String[] args) throws Exception{


        InetAddress local=InetAddress.getByName("www.taobao.com");
        System.out.println(local.getHostAddress());
        System.out.println(local.getHostName());
        System.out.println(local);
        System.out.println("====");
        InetAddress[] inetAddresses=InetAddress.getAllByName("www.taobao.com");
        for (int i = 0; i < inetAddresses.length; i++) {
            System.out.println(inetAddresses[i].getHostAddress());
        }

        //create ByteBuf
        ByteBuf byteBuf= Unpooled.buffer(3);


        byteBuf.writeBytes("netty".getBytes());
        System.out.println(byteBuf.capacity());


        //ByteBuf 核心属性 readerIndex、writeIndex、capacity、maxCapacity
        System.out.println(byteBuf.readerIndex());
        System.out.println(byteBuf.writerIndex());
        System.out.println(byteBuf.capacity());
        System.out.println(byteBuf.maxCapacity());

        System.out.println(byteBuf.readInt());

        System.out.println(byteBuf.readableBytes());
        //random access
        for (int i = 0; i < byteBuf.readableBytes(); i++) {
            System.out.println((char) byteBuf.getByte(i));
        }

        System.out.println("====");
        //
        while (byteBuf.isReadable()){
            System.out.println((char) byteBuf.readByte());
        }


    }

}
