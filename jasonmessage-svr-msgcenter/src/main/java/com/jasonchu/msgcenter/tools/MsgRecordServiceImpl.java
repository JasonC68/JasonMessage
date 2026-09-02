package com.jasonchu.msgcenter.tools;

import com.jasonchu.msgcenter.common.conf.SendMsgConf;
import com.jasonchu.msgcenter.constant.Constants;
import com.jasonchu.msgcenter.enums.MsgStatus;
import com.jasonchu.msgcenter.mapper.MsgRecordMapper;
import com.jasonchu.msgcenter.model.MsgRecordModel;
import com.jasonchu.msgcenter.model.TemplateModel;
import com.jasonchu.msgcenter.model.dto.SendMsgReq;
import com.jasonchu.msgcenter.tools.MsgRecordService;
import com.jasonchu.msgcenter.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;

@Service
@Slf4j
public class MsgRecordServiceImpl implements MsgRecordService {

    @Autowired
    private MsgRecordMapper msgRecordMapper;

    @Autowired
    private SendMsgConf sendMsgConf;

    @Resource
    private RedisTemplate<String,String> redisTemplate;


    @Override
    public MsgRecordModel GetMsgRecordWithCache(String msgId) {
        return getMsgRecordWithCache(msgId);
    }

    @Override
    public void CreateMsgRecord(String msgId, SendMsgReq sendMsgReq, TemplateModel tp, MsgStatus status) {
        // 6. 存储消息发送记录
        MsgRecordModel msgRd = new MsgRecordModel();
        msgRd.setMsgId(msgId);
        msgRd.setTo(sendMsgReq.getTo());
        msgRd.setSubject(sendMsgReq.getSubject());
        msgRd.setTemplateId(sendMsgReq.getTemplateId());
        msgRd.setTemplateData(JSONUtil.toJsonString(sendMsgReq.getTemplateData()));
        msgRd.setMsgId(sendMsgReq.getMsgID());
        msgRd.setSourceId(tp.getSourceId());
        msgRd.setChannel(tp.getChannel());
        msgRd.setStatus(status.getStatus());
        try{
            msgRecordMapper.save(msgRd);
        }catch (Exception e){
            log.error("存储消息发送记录失败， msgId",msgRd.getMsgId());
        }
    }

    @Override
    public void CreateOrUpdateMsgRecord(String msgId, SendMsgReq sendMsgReq, TemplateModel tp, MsgStatus status) {
        MsgRecordModel msgRd = msgRecordMapper.getMsgById(msgId);
        if(msgRd == null){
            msgRd = new MsgRecordModel();
            msgRd.setMsgId(msgId);
            msgRd.setTo(sendMsgReq.getTo());
            msgRd.setSubject(sendMsgReq.getSubject());
            msgRd.setTemplateId(sendMsgReq.getTemplateId());
            msgRd.setTemplateData(JSONUtil.toJsonString(sendMsgReq.getTemplateData()));
            msgRd.setMsgId(sendMsgReq.getMsgID());
            msgRd.setSourceId(tp.getSourceId());
            msgRd.setChannel(tp.getChannel());
            msgRd.setStatus(status.getStatus());
            try{
                msgRecordMapper.save(msgRd);
            }catch (Exception e){
                log.error("存储消息发送记录失败， msgId",msgRd.getMsgId());
            }
        }else{
            try{
                msgRecordMapper.setStatus(msgId,status.getStatus());
            }catch (Exception e){
                log.error("更新消息发送记录状态失败， msgId,status",msgRd.getMsgId(),status);
            }
        }
    }

    public MsgRecordModel getMsgRecordWithCache(String msgId) {
        String msgRecordCacheKey = Constants.REDIS_KEY_MES_RECORD+msgId;
        String cacheMr = redisTemplate.opsForValue().get(msgRecordCacheKey);
        MsgRecordModel mr = null;
        if(!StringUtils.isEmpty(cacheMr) && sendMsgConf.isOpenCache()){
            mr = JSONUtil.parseObject(cacheMr,MsgRecordModel.class);
            if(mr != null){
                return mr;
            }
        }

        // 从数据库获取
        mr = msgRecordMapper.getMsgById(msgId);

        // 存入缓存
        redisTemplate.opsForValue().set(msgRecordCacheKey,JSONUtil.toJsonString(mr), Duration.ofSeconds(30));

        return mr;
    }
}
