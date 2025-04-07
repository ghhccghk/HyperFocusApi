package com.hyperfocus.api.info;

import java.util.Objects;

public final class ProgressInfo {
    private String colorProgress;
    private String colorProgressEnd;
    private String picEnd;
    private String picEndUnselected;
    private String picForward;
    private String picMiddle;
    private String picMiddleUnselected;
    private Integer progress;

    public ProgressInfo setColorProgress(String colorProgress) {
        this.colorProgress = colorProgress;
        return this;
    }

    public ProgressInfo setColorProgressEnd(String colorProgressEnd) {
        this.colorProgressEnd = colorProgressEnd;
        return this;
    }

    public ProgressInfo setPicEnd(String picEnd) {
        this.picEnd = "miui.focus.pic_" + picEnd;
        return this;
    }

    public ProgressInfo setPicEndUnselected(String picEndUnselected) {
        this.picEndUnselected = "miui.focus.pic_" + picEndUnselected;
        return this;
    }

    public ProgressInfo setPicForward(String picForward) {
        this.picForward = "miui.focus.pic_" + picForward;
        return this;
    }

    public ProgressInfo setPicMiddle(String picMiddle) {
        this.picMiddle = "miui.focus.pic_" + picMiddle;
        return this;
    }

    public ProgressInfo setPicMiddleUnselected(String picMiddleUnselected) {
        this.picMiddleUnselected = "miui.focus.pic_" + picMiddleUnselected;
        return this;
    }

    public ProgressInfo setProgress(Integer progress) {
        this.progress = progress;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ProgressInfo that)) return false;
        return Objects.equals(colorProgress, that.colorProgress) && Objects.equals(colorProgressEnd, that.colorProgressEnd) && Objects.equals(picEnd, that.picEnd) && Objects.equals(picEndUnselected, that.picEndUnselected) && Objects.equals(picForward, that.picForward) && Objects.equals(picMiddle, that.picMiddle) && Objects.equals(picMiddleUnselected, that.picMiddleUnselected) && Objects.equals(progress, that.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorProgress, colorProgressEnd, picEnd, picEndUnselected, picForward, picMiddle, picMiddleUnselected, progress);
    }

    @Override
    public String toString() {
        return "ProgressInfo{" +
            "colorProgress='" + colorProgress + '\'' +
            ", colorProgressEnd='" + colorProgressEnd + '\'' +
            ", picEnd='" + picEnd + '\'' +
            ", picEndUnselected='" + picEndUnselected + '\'' +
            ", picForward='" + picForward + '\'' +
            ", picMiddle='" + picMiddle + '\'' +
            ", picMiddleUnselected='" + picMiddleUnselected + '\'' +
            ", progress=" + progress +
            '}';
    }
}
