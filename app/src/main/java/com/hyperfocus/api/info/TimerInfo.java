package com.hyperfocus.api.info;

import java.util.Objects;

public final class TimerInfo {
    private Long timerSystemCurrent;
    private long timerTotal;
    private int timerType;
    private Long timerWhen;

    public TimerInfo setTimerSystemCurrent(Long timerSystemCurrent) {
        this.timerSystemCurrent = timerSystemCurrent;
        return this;
    }

    public TimerInfo setTimerTotal(long timerTotal) {
        this.timerTotal = timerTotal;
        return this;
    }

    public TimerInfo setTimerType(int timerType) {
        this.timerType = timerType;
        return this;
    }

    public TimerInfo setTimerWhen(Long timerWhen) {
        this.timerWhen = timerWhen;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof TimerInfo timerInfo)) return false;
        return timerTotal == timerInfo.timerTotal && timerType == timerInfo.timerType && Objects.equals(timerSystemCurrent, timerInfo.timerSystemCurrent) && Objects.equals(timerWhen, timerInfo.timerWhen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timerSystemCurrent, timerTotal, timerType, timerWhen);
    }

    @Override
    public String toString() {
        return "TimerInfo{" +
            "timerSystemCurrent=" + timerSystemCurrent +
            ", timerTotal=" + timerTotal +
            ", timerType=" + timerType +
            ", timerWhen=" + timerWhen +
            '}';
    }
}
