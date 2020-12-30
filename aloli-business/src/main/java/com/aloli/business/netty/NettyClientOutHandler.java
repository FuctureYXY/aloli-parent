package com.aloli.business.netty;

import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@ChannelHandler.Sharable
public class NettyClientOutHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx , Object msg, ChannelPromise promise) throws  Exception{

        log.info("进入Outhandler,发送内容为"+msg);
        super.write(ctx,msg,promise);

    }
}
