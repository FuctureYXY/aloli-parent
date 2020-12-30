package com.aloli.security.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
@Slf4j
public class NettyServer {
    //自定义分隔符
    public  static final String DELIMITER = "@@";
    //boss线程组用于处理连接工作     默认是系统CPU个数的两倍    也可以根据实际情况指定
    private EventLoopGroup boss = new NioEventLoopGroup();
    //work线程组用于数据处理工作    默认是系统CPU个数的两倍    也可以根据实际情况而定
    private EventLoopGroup work = new NioEventLoopGroup();
    //监听端口
    private Integer port = 8888;

    private NettyServerHandleInitializer handlerInitalizer = new NettyServerHandleInitializer();

    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start();
    }

    public void start(){
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss,work)
                    //指定channel
                    .channel(NioServerSocketChannel.class)
                    //使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    //服务端可连接队列数，对应TCP/IP协议listen函数中的backlog参数
                    .option(ChannelOption.SO_BACKLOG,1024)
                    //设置TCP长连接 一般如果两个小时没有数据的通信时 TCP会自动发送一个活动探测数据报
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    //将小的数据包包装成更大  的帧进行传送 提高网络的负载 即TCP延迟传输
                    .childOption(ChannelOption.TCP_NODELAY,true)

                    .childHandler(handlerInitalizer);
            ChannelFuture future = bootstrap.bind().sync();
            if(future.isSuccess()){
                log.info("启动nettyServer");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
