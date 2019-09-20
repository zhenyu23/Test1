package nettytest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author czy
 * @date 2019/9/11 10:07
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 打印服务端发送过来的数据
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);
    }
}