package com.jasonchu.msgcenter.mapper;


import com.jasonchu.msgcenter.model.GlobalQuotaModel;
import com.jasonchu.msgcenter.model.SourceQuotaModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SourceQuotaMapper {

    void save(@Param("sourceQuotaModel") SourceQuotaModel sourceQuotaModel);

    SourceQuotaModel getSourceQuota(@Param("channel") int channel,@Param("sourceId") String sourceId);
}
