package com.nettytest1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author czy
 * @date 2019/9/18 11:17
 */
public class NettyClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup group =new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>(){
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast("decoder", new StringDecoder());
                            p.addLast("encoder", new StringEncoder());
                            p.addLast(new ClientHandler());
                            //p.addLast(new ClientHandlerBak());
                        }
                    });

            ChannelFuture future = b.connect("127.0.0.1", 8099).sync();
            future.channel().writeAndFlush("这里是客户端，请求连接服务端！");
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }
}