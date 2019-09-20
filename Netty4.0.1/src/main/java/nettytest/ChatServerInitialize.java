package nettytest;

import nettytest.ChatServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author czy
 * @date 2019/9/11 10:04
 */
public class ChatServerInitialize extends ChannelInitializer<SocketChannel> {

    public ChatServerInitialize(){
    }
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        System.out.println("用户【"+channel.remoteAddress()+"】接入聊天室......");
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast("decoder",new StringDecoder());
        pipeline.addLast("encoder",new StringEncoder());
        pipeline.addLast("handler",new ChatServerHandler());
    }

}