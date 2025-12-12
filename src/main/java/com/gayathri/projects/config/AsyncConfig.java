package com.gayathri.projects.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/*@EnableAsync denotes that the class can be executed in different thread instead of blocking the thread or waiting for blocked threads
*@Configuration marks a class as a bean
 */
@EnableAsync
@Configuration
class AsyncConfig
{
    @Bean(name = "taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // Minumum number of threads
        executor.setMaxPoolSize(5); // Maximum number of threads
        executor.setQueueCapacity(100); // Queue capacity
        executor.setThreadNamePrefix("Async-");
        executor.initialize();

        return executor;
    }
}