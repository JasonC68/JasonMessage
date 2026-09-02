package com.jasonchu.asyncflow.dto;

import lombok.Data;

@Data
public class GetTaskReply {
    private TaskData taskData;

    public GetTaskReply() {
        this.taskData = new TaskData();
    }
}

