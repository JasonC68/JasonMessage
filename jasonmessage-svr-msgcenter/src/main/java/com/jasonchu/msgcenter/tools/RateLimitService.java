package com.jasonchu.msgcenter.tools;

public interface RateLimitService {

    boolean isRequestAllowed(String sourceId,int channel,boolean isTimerMsg);
}
