package service_breaker.core;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Metrics {

    private long windowBatch;
    private LocalDateTime nextWindowTimeStart;
    private long countAll;
    private long countSuccess;
    private long countFail;
    private long consecutiveSuccess;    //连续成功数
    private long consecutiveFail;       //连续失败数

    public void newBatch() {
        this.windowBatch++;
    }

    public void onCall() {
        this.countAll++;
    }

    public void onSuccess() {
        this.countSuccess++;
        this.consecutiveSuccess++;
        this.consecutiveFail = 0;
    }

    public void onFail() {
        this.countFail++;
        this.consecutiveFail++;
        this.consecutiveSuccess = 0;
    }

    public void reset() {
        this.countAll = 0;
        this.countSuccess = 0;
        this.countFail = 0;
        this.consecutiveSuccess = 0;
        this.consecutiveFail = 0;
    }
}

