package learn_netty.bioecho;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * bio 客户端代码
 */
public class EchoClient {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //定义客户端套接字
        Socket socket = new Socket();
        //连接远程主机(阻塞方法)
        socket.connect(new InetSocketAddress("localhost", 9000));

        //从套接字获取输入输出字节流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        while (true) {
            //向服务器发送信息
            System.out.print("input:");
            String line = scanner.nextLine();
            if (line != null) {
                printWriter.println(line);
                printWriter.flush();//刷出缓冲数据
            }
            //读取服务器发送回来的信息
            String data = bufferedReader.readLine();
            System.out.println("output:" + data);
        }
    }

}
