package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

//@Component
@Slf4j
public class MyTestTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void executeTask(){
        log.error("定时执行任务：{}", LocalDateTime.now());
    }
}
