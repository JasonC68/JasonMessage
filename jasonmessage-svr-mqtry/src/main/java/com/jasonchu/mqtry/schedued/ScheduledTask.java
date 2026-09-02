package com.jasonchu.mqtry.schedued;

import com.jasonchu.mqtry.mapper.CountMapper;
import com.jasonchu.mqtry.service.CountService;
import com.jasonchu.mqtry.service.impl.CountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时任务模版
 *
 **/
@Component
public class ScheduledTask {
    @Autowired
    private CountService service;
    @Scheduled(fixedRate = 3000)
    public void scheduledTask() {
        //service.incrMemCountAndReset();
        //System.out.println("任务执行时间 isis：" + LocalDateTime.now());
    }

}
