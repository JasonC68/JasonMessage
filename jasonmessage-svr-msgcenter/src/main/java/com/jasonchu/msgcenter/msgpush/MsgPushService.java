package com.jasonchu.msgcenter.msgpush;

import com.jasonchu.msgcenter.model.dto.SendMsgReq;
import com.jasonchu.msgcenter.msgpush.base.ChannelMsgBase;

public interface MsgPushService {
    void pushMsg(ChannelMsgBase msgBase);
}
