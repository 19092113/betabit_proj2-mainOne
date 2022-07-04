package nl.betabit.betabit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void setRewardLog() {
        ArrayList<RewardLog> rewardLog = new ArrayList<>();
        rewardLog.add(new RewardLog("test", "test", 4,""));
        Data.setRewardLog(rewardLog);
        assertEquals(rewardLog, Data.getRewardLog());
    }

    @Test
    void setLog() {
        ArrayList<distanceLog> log = new ArrayList<>();
        log.add(new distanceLog("test", "test", "Lopen",23,100,1111));
        Data.setLog(log);
        assertEquals(log, Data.getLog());
    }
}