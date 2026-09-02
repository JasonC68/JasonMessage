package com.jasonchu.asyncflow.dto;

import lombok.Data;

import java.util.List;

@Data
public class HoldTasksReply {
    private List<TaskData> taskList;
}
