package com.jasonchu.api.feign;


import com.jasonchu.api.dto.xtimer.TimerDTO;
import com.jasonchu.api.feign.interceptor.ContextFeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "jasonmessage-svr-xtimer",configuration = ContextFeignInterceptor.class)
public interface XTimerClient {

    @PostMapping(value = "/createTimer")
    public Long createTimer(@RequestBody TimerDTO timerDTO);

    @GetMapping(value = "/enableTimer")
    public void enableTimer(@RequestParam(value = "app") String app,
                            @RequestParam(value = "timerId") Long timerId,
                            @RequestHeader MultiValueMap<String, String> headers);

}
