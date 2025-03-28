package com.hyperfocus.api.info;

import android.annotation.SuppressLint;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import java.util.Objects;

@SuppressLint("NewApi")
public final class HighlightInfo extends TextAndColorInfo {
    private String picFunction;
    private String picFunctionDark;
    private TimerInfo timerInfo;
    private int type = 1;
    transient Bundle picBundle = new Bundle();

    public HighlightInfo setPicFunction(Icon picFunction) {
        this.picFunction = "miui.focus.pic_notification";
        picBundle.putParcelable("miui.focus.pic_notification", picFunction);
        return this;
    }

    public HighlightInfo setPicFunctionDark(Icon picFunctionDark) {
        this.picFunctionDark = "miui.focus.pic_notification_dark";
        picBundle.putParcelable("miui.focus.pic_notification_dark", picFunctionDark);
        return this;
    }

    public HighlightInfo setTimerInfo(TimerInfo timerInfo) {
        this.timerInfo = timerInfo;
        return this;
    }

    public HighlightInfo setType(int type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof HighlightInfo that)) return false;
        return type == that.type && Objects.equals(picFunction, that.picFunction) && Objects.equals(picFunctionDark, that.picFunctionDark) && Objects.equals(timerInfo, that.timerInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(picFunction, picFunctionDark, timerInfo, type);
    }

    @Override
    public String toString() {
        return "HighlightInfo{" +
            "picFunction='" + picFunction + '\'' +
            ", picFunctionDark='" + picFunctionDark + '\'' +
            ", timerInfo=" + timerInfo +
            ", type=" + type +
            "} " + super.toString();
    }
}
