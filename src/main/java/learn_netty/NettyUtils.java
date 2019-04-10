package learn_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class NettyUtils {


    public ServerBootstrap createServerBootstarp() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup boosGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        serverBootstrap.group(boosGroup, workGroup);
        return serverBootstrap;
    }

}
