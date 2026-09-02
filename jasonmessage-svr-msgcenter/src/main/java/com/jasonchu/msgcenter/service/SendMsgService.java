package com.jasonchu.msgcenter.service;

import com.jasonchu.msgcenter.model.TemplateModel;
import com.jasonchu.msgcenter.model.dto.SendMsgReq;

public interface SendMsgService {

    String SendMsg(SendMsgReq sendMsgReq);

}
