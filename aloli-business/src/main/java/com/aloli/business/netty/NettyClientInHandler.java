package com.aloli.business.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Slf4j
@Component
@ChannelHandler.Sharable
public class NettyClientInHandler extends SimpleChannelInboundHandler<String> {
    @Autowired
    private NettyClient nettyClient;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("收到服务端消息内容"+msg);
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx ) throws Exception{

        log.info("连接成功");
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx)throws  Exception{
        log.info("连接被断开");
        //使用过程中断线重新连接
        final EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(new Runnable(){
            @Override
            public void run() {
                nettyClient.start();
            }
        },20, TimeUnit.SECONDS
        );

    }
}
