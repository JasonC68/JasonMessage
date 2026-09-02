package com.jasonchu.msgcenter.manager;

import com.jasonchu.msgcenter.model.dto.SendMsgReq;

public interface DealMsgManager {

    public void DealOneMsg(SendMsgReq sendMsgReq);
}
