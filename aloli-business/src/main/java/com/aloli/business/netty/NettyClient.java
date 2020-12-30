package com.aloli.business.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.PostConstruct;


import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Slf4j
@Component
public class NettyClient {

    private EventLoopGroup group = new NioEventLoopGroup();

    public  static final String DELIMIER ="@@";

    private String hostIp = "127.0.0.1";

    private int port = 8888;

    private SocketChannel socketChannel;
    @Autowired
    private NettyClientHandlerInitlizer clientHandlerInitlizer;

    @PostConstruct
    public void start(){
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(hostIp,port)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(clientHandlerInitlizer);
        //连接
        ChannelFuture channelFuture = bootstrap.connect();
        //客户端短线重连逻辑
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    log.info("连接成功");
                }else{
                    log.info("连接失败 进行断线重连");
                    final EventLoop loop = future.channel().eventLoop();
                    loop.schedule(new Runnable() {
                        @Override
                        public void run() {
                            log.info("连接正在重试");
                            start();
                        }
                    },20, TimeUnit.SECONDS);
                }

            }
        });
        socketChannel = (SocketChannel)channelFuture.channel();
    }

    /**
     * 消息发送
     * @param msg
     */
    public void sendMsg(String msg){
        ChannelFuture future  = socketChannel.writeAndFlush(msg+NettyClient.DELIMIER);
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    log.info("发送成功");

                }else{
                    log.info("发送失败");

                }
            }
        });
    }




}
