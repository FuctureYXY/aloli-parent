package com.aloli.security.netty;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * handler的初始化
 */
public class NettyServerHandleInitializer extends ChannelInitializer<Channel> {

    private NettyServerHandler serverHandler = new NettyServerHandler();


    @Override
    protected void initChannel(Channel ch) throws Exception {
        //通过socketChannel 去获取对应的管道
        ChannelPipeline channelPipeline = ch.pipeline();
        //往pipeline链中添加一个 以 "@@" 为结尾分割的 解码器
        ByteBuf buf = Unpooled.copiedBuffer(NettyServer.DELIMITER.getBytes());
        channelPipeline.addLast("framer",new DelimiterBasedFrameDecoder(1024,buf));
        //往pipeline链中添加一个解码器
        channelPipeline.addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
        //往pipeline链中添加一个编码器
        channelPipeline.addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        //往pipeline链中添加一个字定义的hanler 业务处理器
        channelPipeline.addLast(serverHandler);
    }
}
