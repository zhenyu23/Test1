package nettytest;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 聊天客户端
 */
public class ChatClient {

    private final String host;

    private final int port;

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        try{
            bootstrap.group(worker)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());
            Channel channel  = bootstrap.connect(host,port).sync().channel();
            //客户端从键盘输入数据
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                channel.writeAndFlush(input.readLine()+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChatClient("127.0.0.1",9999).start(); //连接服务器端
    }

}