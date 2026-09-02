package com.jasonchu.msgcenter.tools;

import com.jasonchu.msgcenter.enums.MsgStatus;
import com.jasonchu.msgcenter.model.MsgRecordModel;
import com.jasonchu.msgcenter.model.TemplateModel;
import com.jasonchu.msgcenter.model.dto.SendMsgReq;

public interface MsgRecordService {

    MsgRecordModel GetMsgRecordWithCache(String msgId);

    void CreateMsgRecord(String msgId,SendMsgReq sendMsgReq, TemplateModel tp, MsgStatus status);

    void CreateOrUpdateMsgRecord(String msgId,SendMsgReq sendMsgReq, TemplateModel tp, MsgStatus status);
}
