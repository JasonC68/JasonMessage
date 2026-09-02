package com.jasonchu.improve.service.impl;

import com.jasonchu.common.redis.RedisBase;
import com.jasonchu.improve.mapper.TaskMapper;
import com.jasonchu.improve.model.Task;
import com.jasonchu.improve.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class TaskServiceImpl implements TaskService {
    public static Integer tmpTask = 0;
    public static final Lock lock = new ReentrantLock();

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void save(Task task) {
        taskMapper.save(task);
    }
}
