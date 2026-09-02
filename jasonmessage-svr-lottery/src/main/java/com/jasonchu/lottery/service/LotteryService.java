package com.jasonchu.lottery.service;

import com.jasonchu.lottery.model.LotteryPrizeInfo;
import com.jasonchu.lottery.model.LotteryResult;

import java.text.ParseException;

public interface LotteryService {

    LotteryResult lottery(Long userID, String userName, String ip) throws ParseException;

//    LotteryPrizeInfo lotteryV2(int userID,String userName,String ip);
//
//    LotteryPrizeInfo lotteryV3(int userID,String userName,String ip);
}
