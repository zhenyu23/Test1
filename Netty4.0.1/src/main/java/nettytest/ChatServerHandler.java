package nettytest;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 聊天服务器对各种情况的处理
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 当从服务端收到新的客户端连接时
     * 客户端的 Channel 存入 channels 列表中，并通知列表中的其他客户端 Channel
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel clientChannel = ctx.channel();
        channels.add(clientChannel);
        for (Channel ch : channels) {
            if (ch != clientChannel) {  //通知除了自己以外的其他用户
                ch.writeAndFlush("【提示】：用户【" + clientChannel.remoteAddress() + "】进入聊天室...\n");
            }
        }
    }


    /**
     * 每当从服务端收到客户端断开时
     * 客户端的 Channel 自动从 channels 列表中移除了，并通知列表中的其他客户端 Channel
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel clientChannel = ctx.channel();
        channels.remove(clientChannel);
        for (Channel ch : channels) {
            if (ch != clientChannel) {  //通知除了自己以外的其他用户
                ch.writeAndFlush("【提示】：用户【" + clientChannel.remoteAddress() + "】退出聊天室...\n");
            }
        }
    }

    /**
     * 接受到客户端发出的消息
     * 判断channel是否是
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel clientChannel = ctx.channel();
        for (Channel ch : channels) {
            if (ch != clientChannel) {
                ch.writeAndFlush("用户【" + clientChannel.remoteAddress() + "】说：" + msg + "\n");
            } else {
                ch.writeAndFlush("【我】说：" + msg + "\n");
            }
        }
    }

    /**
     * 服务端监听到客户端活动
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel clientChannel = ctx.channel();
        System.out.println("用户【"+clientChannel.remoteAddress()+"】在线中...");
    }

    /**
     * 服务端监听到客户端 不活动
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel clientChannel = ctx.channel();
        System.out.println("用户【 " +clientChannel.remoteAddress()+"】:离线了");

    }
}