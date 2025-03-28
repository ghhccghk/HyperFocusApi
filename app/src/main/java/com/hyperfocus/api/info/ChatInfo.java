package com.hyperfocus.api.info;

import java.util.Objects;

public final class ChatInfo extends TextAndColorInfo {
    private String picProfile;
    private TimerInfo timerInfo;

    public ChatInfo setPicProfile(String picProfile) {
        this.picProfile = picProfile;
        return this;
    }

    public ChatInfo setTimerInfo(TimerInfo timerInfo) {
        this.timerInfo = timerInfo;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ChatInfo chatInfo)) return false;
        return Objects.equals(picProfile, chatInfo.picProfile) && Objects.equals(timerInfo, chatInfo.timerInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(picProfile, timerInfo);
    }

    @Override
    public String toString() {
        return "ChatInfo{" +
            "picProfile='" + picProfile + '\'' +
            ", timerInfo=" + timerInfo +
            "} " + super.toString();
    }
}
