package learn_netty.discard;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import learn_netty.NettyUtils;

public class DiscardClient {

    public static void main(String[] args) throws Exception {

        Bootstrap bootstrap = NettyUtils.createBootstrap();
        try {
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline channelPipeline = ch.pipeline();
                    channelPipeline.addLast(new DiscardClientHandler());
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("localhost", 9000);
            channelFuture.channel().closeFuture().sync();
        } finally {
        }
    }
}
