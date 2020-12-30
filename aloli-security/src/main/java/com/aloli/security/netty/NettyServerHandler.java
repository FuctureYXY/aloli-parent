package com.aloli.security.netty;

import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
@ChannelHandler.Sharable  // 标注一个channel hanlder 可以被多个channel安全的共享
public class NettyServerHandler  extends SimpleChannelInboundHandler<String> {

    public static AtomicInteger nConnection = new AtomicInteger(0);
    @Override
    protected  void channelRead0(ChannelHandlerContext ctx ,String msg) throws  Exception{
        //收到消息并输出
        log.info("收到客户端"+ctx.channel().remoteAddress()+"的内容"+msg);
        //返回客户端消息 --  我已经收到了消息
        ackMessage(ctx,msg);

    }

    /**
     * 确认消息
     */
    public void ackMessage(ChannelHandlerContext ctx ,String message){
        //字定义分割符
        String msg  = message+NettyServer.DELIMITER;
        //回应客户端
        ctx.writeAndFlush(msg);
    }

    /**
     * TCP连接成功即会触发这里
     * 每次进来一个新连接就对连接数加一
     *
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        nConnection.incrementAndGet();
        log.info("请求连接..."+ctx.channel().id()+",当前连接数"+nConnection.get());

    }

    /**
     * tcp连接异常的时候回调
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable  cause) throws Exception{
        super.exceptionCaught(ctx, cause);
        //打印错误日志
        cause.printStackTrace();
        Channel channel = ctx.channel();
        nConnection.decrementAndGet();
        log.info("nConnection"+nConnection);
        if(channel.isActive()){
            ctx.close();
        }
    }

}
