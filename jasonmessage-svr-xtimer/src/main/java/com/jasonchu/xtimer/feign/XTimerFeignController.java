package com.jasonchu.xtimer.feign;

import com.jasonchu.api.dto.xtimer.TimerDTO;
import com.jasonchu.api.feign.XTimerClient;
import com.jasonchu.xtimer.service.XTimerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class XTimerFeignController implements XTimerClient {

    @Autowired
    XTimerService xTimerService;

    @Override
    public Long createTimer(TimerDTO timerDTO) {
        return xTimerService.CreateTimer(timerDTO);
    }

    @Override
    public void enableTimer(String app, Long timerId, MultiValueMap<String, String> headers) {
        xTimerService.EnableTimer(app, timerId);
    }
}
