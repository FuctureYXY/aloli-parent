package com.aloli.business.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyClientHandlerInitlizer  extends ChannelInitializer<Channel> {
    @Autowired
    NettyClientInHandler nettyClientInHandler;
    @Autowired
    NettyClientOutHandler nettyClientOutHandler;

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        ByteBuf buf  = Unpooled.copiedBuffer(NettyClient.DELIMIER.getBytes());
        channelPipeline.addLast("framer",new DelimiterBasedFrameDecoder(1024,buf));
        channelPipeline.addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        channelPipeline.addLast("decoder",new StringEncoder(CharsetUtil.UTF_8));
        channelPipeline.addLast(nettyClientInHandler);
        channelPipeline.addLast(nettyClientOutHandler);
    }
}
