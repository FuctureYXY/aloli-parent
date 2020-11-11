package com.aloli.config.threadpool;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

// 开启异步任务支持
@EnableAsync
@Configuration
public class SyncConfiguration {
    /**
     * 自定义线程池
     * 使用方式  方法上面加 @Async("syncPoolTaskExecutor")
     * 注意  异步方法和调用方法一定要     写在不同的类中    如果写在一个类中, 是没有效果的 即需要controller 调用service 才会剩下
     *  不同的线程 事务是不生效的    因此 使用另一条线程去执行   如果报错 对当前线程是没影响的 当前线程默认他成功
     *  并且 这个线程是没办法放回数据给  当前线程的
     *
     * 而对于事务
     *  controller 调用   没加service  然后  service 加了事务  只处理 service 事务
     *  service.a() 调用 service.b()     只有 a()加了事务才生效   就算b加了事务也不生效
     *
     *   因此 完美的使用方法是  调用到了改service 加上注解即可
     *
     * @return
     */
    @Bean(name="syncPoolTaskExecutor")
    public ThreadPoolTaskExecutor syncPool() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数
        taskExecutor.setCorePoolSize(12);
        //线程池维护线程的最大数量  只有在缓冲队列满了之后才会申请超过核心线程数的数量
        taskExecutor.setMaxPoolSize(100);
        //缓存队列
        taskExecutor.setQueueCapacity(50);
        //允许的空闲时间,当超过了核心线程数之外的线程在空显时间到达后都会被销毁
        taskExecutor.setKeepAliveSeconds(200);
        //异步方法内部线程名称
        taskExecutor.setThreadNamePrefix("sync--");
        //当线程池的任务缓存已满并且线程池中的线程数目达到maximumPoolSize   如果还有任务到来就会采取 任务拒绝策略
        //通常有以下四种策略
        //ThreadPoolExecutor.AbortPolicy: 丢弃任务并抛出RejectdExecutionException 异常
        //ThreadPoolExecutor.DiscardPolicy: 丢弃任务 不抛出异常
        //ThreadPoolExecutor.DiscardOldestPolicy 丢弃队列最前面的任务 然后重新执行任务 重复此过程
        //ThreadPoolExecutor.CallerRunsPolicy  重试添加当前任务  自动重复调用execute方法 直到成功为止
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }


}
