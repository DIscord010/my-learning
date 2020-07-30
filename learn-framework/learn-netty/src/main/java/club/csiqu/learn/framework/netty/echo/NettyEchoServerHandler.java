package club.csiqu.learn.framework.netty.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chensiqu 2020/1/3
 * @since 1.0
 */
public class NettyEchoServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyEchoServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("收到客户端: {} 消息：{}", ctx.channel().remoteAddress(), msg);
        }
        ctx.writeAndFlush(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        LOGGER.warn("Netty exception:", cause);
        ctx.close();
    }
}