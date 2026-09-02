package com.jasonchu.msgcenter.mapper;


import com.jasonchu.msgcenter.model.MsgQueueModel;
import com.jasonchu.msgcenter.model.MsgQueueTimerModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MsgQueueTimerMapper {

    void save(@Param("msgQueueTimerModel") MsgQueueTimerModel msgQueueTimerModel);

    List<MsgQueueTimerModel> getOnTimeMsgsList(@Param("status") int status, @Param("nowTimestamp") long nowTimestamp);

    void batchSetStatus(@Param("msgIdList") String msgIdList,@Param("status") int status);

    void setStatus(@Param("msgId") String msgId,@Param("status") int status);
}
