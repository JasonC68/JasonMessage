package com.jasonchu.msgcenter.manager;

import com.jasonchu.msgcenter.model.dto.SendMsgReq;

public interface SendMsgManager{
    public String SendToMysql(SendMsgReq sendMsgReq);
    public String SendToMq(SendMsgReq sendMsgReq);

    public String SendToTimer(SendMsgReq sendMsgReq);
}
