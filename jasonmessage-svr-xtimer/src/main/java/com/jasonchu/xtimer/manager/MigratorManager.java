package com.jasonchu.xtimer.manager;

import com.jasonchu.xtimer.model.TimerModel;

public interface MigratorManager{
    public void migrateTimer(TimerModel timerModel);
}
