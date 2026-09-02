package com.jasonchu.asyncflow.dto;

import lombok.Data;

@Data
public class HoldTasksRequest {
    private String taskType;
    private int limit;
}
