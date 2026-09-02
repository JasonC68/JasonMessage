package com.jasonchu.improve.service;

import com.jasonchu.improve.model.Count;

public interface CountService {

    void save(Count example);

    void update(Count example);

    void incrCount(Integer num);
    void incrMemCountAndReset();
    void incrCountAsync(Integer num);



}
