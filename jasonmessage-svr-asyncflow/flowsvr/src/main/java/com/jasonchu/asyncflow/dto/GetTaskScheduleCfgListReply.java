package com.jasonchu.asyncflow.dto;

import com.jasonchu.asyncflow.model.TaskScheduleCfgModel;
import lombok.Data;

import java.util.List;

@Data
public class GetTaskScheduleCfgListReply {
    private List<TaskScheduleCfgModel> taskScheduleCfgList;

}
