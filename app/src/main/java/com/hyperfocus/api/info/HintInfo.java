package com.hyperfocus.api.info;


import java.util.Objects;

public final class HintInfo extends TextAndColorInfo {
    private ActionInfo actionInfo;
    private String colorContentBg;
    private String picContent;
    private TimerInfo timerInfo;
    private int titleLineCount;
    private Integer type = 1;

    public HintInfo setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
        return this;
    }

    public HintInfo setColorContentBg(String colorContentBg) {
        this.colorContentBg = colorContentBg;
        return this;
    }

    public HintInfo setPicContent(String picContent) {
        this.picContent = "miui.focus.pic_" + picContent;
        return this;
    }

    public HintInfo setTimerInfo(TimerInfo timerInfo) {
        this.timerInfo = timerInfo;
        return this;
    }

    public HintInfo setTitleLineCount(int titleLineCount) {
        this.titleLineCount = titleLineCount;
        return this;
    }

    public HintInfo setType(Integer type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof HintInfo hintInfo)) return false;
        return titleLineCount == hintInfo.titleLineCount && Objects.equals(actionInfo, hintInfo.actionInfo) && Objects.equals(colorContentBg, hintInfo.colorContentBg) && Objects.equals(picContent, hintInfo.picContent) && Objects.equals(timerInfo, hintInfo.timerInfo) && Objects.equals(type, hintInfo.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionInfo, colorContentBg, picContent, timerInfo, titleLineCount, type);
    }

    @Override
    public String toString() {
        return "HintInfo{" +
            "actionInfo=" + actionInfo +
            ", colorContentBg='" + colorContentBg + '\'' +
            ", picContent='" + picContent + '\'' +
            ", timerInfo=" + timerInfo +
            ", titleLineCount=" + titleLineCount +
            ", type=" + type +
            "} " + super.toString();
    }
}
