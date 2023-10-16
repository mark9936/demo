package com.demo.config.async;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import lombok.Data;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Data
@EnableAsync
@Configuration
@ConfigurationProperties(prefix = "spring.task.pool")
public class AsyncConfig implements AsyncConfigurer {

    public static final String ASYN_EXECUTOR = "asyn_executor";

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    private String threadNamePrefix;

    /**
     * @formatter:off
     * 1、corePoolSize 核心執行緒數大小，當執行緒數 < corePoolSize ，會建立執行緒執行runnable <br>
     * 2、maximumPoolSize 最大執行緒數，當執行緒數 >= corePoolSize的時候，會把 runnable 放入 workQueue中 <br>
     * 3、keepAliveTime 保持存活時間，當執行緒數 > corePoolSize 的空閒執行緒能保持的最大時間 <br>
     * 4、unit 時間單位 <br>
     * 5、workQueue 儲存任務的阻塞佇列 <br>
     * 6、threadFactory 建立執行緒的工廠 <br>
     * 7、handler 拒絕策略
     * <p>
     * 任務執行順序: <br>
     * 1、當執行緒數 < corePoolSize 時，建立執行緒執行任務。 <br>
     * 2、當執行緒數 >= corePoolSize 並且 workQueue 沒有滿時，放入 workQueue 中 <br>
     * 3、當執行緒數 >= corePoolSize 並且當 workQueue 滿時，新任務新建執行緒執行，執行緒總數要 < maximumPoolSize <br>
     * 4、當執行緒總數 = maximumPoolSize 並且 workQueue 滿了的時候執行 handler 的 rejectedExecution 。也就是拒絕策略。
     * <p>
     * ThreadPoolExecutor 預設有四個拒絕策略: <br>
     * 1、ThreadPoolExecutor.AbortPolicy() 直接丟擲異常 RejectedExecutionException <br>
     * 2、ThreadPoolExecutor.CallerRunsPolicy() 直接呼叫 run 方法並且阻塞執行 <br>
     * 3、ThreadPoolExecutor.DiscardPolicy() 直接丟棄後來的任務 <br>
     * 4、ThreadPoolExecutor.DiscardOldestPolicy() 丟棄在佇列中隊首的任務，當然可以自己繼承 RejectedExecutionHandler 來寫拒絕策略
     * @formatter:on
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }

    @Bean(name = ASYN_EXECUTOR)
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }

}
