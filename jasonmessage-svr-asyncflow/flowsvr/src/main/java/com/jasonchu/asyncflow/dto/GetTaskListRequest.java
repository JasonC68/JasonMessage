package com.jasonchu.asyncflow.dto;

import lombok.Data;

@Data
public class GetTaskListRequest {
    private String taskType;
    private int limit;
    private int status;
}
