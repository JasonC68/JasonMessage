package com.jasonchu.seckill.feign;

import com.jasonchu.seckill.service.SecKillService;
import com.jasonchu.api.feign.TestSeckillClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SecKillFeignController implements TestSeckillClient {

    @Autowired
    private SecKillService secKillService;
    public String call(String name) {
        return "";
    }
}
