package club.csiqu.learn.framework.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author chensiqu 2020/1/3
 * @since 1.0.0
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        // 配置客户端
        EventLoopGroup group = new NioEventLoopGroup(10);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new NettyClientHandler());

            ChannelFuture future = bootstrap
                    .connect("localhost", 8000);

            future.channel().closeFuture().sync();
        } finally {
            // 优雅的关闭
            group.shutdownGracefully();
        }
    }
}