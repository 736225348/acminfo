package com.dqsy.algorithmhome.hdoj.Task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class climbdata {
    //0 0 10,14,16 * * ? 每天上午10点，下午2点，10点
    // @Scheduled(cron = "0 0 10,14,22 * * ?")
    public void test() {
        System.out.println("定时任务...");
    }

}
