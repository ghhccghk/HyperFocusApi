package com.hyperfocus.api.info;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import java.util.Objects;

public final class PicInfo {
    private ActionInfo actionInfo;
    private String pic;
    private Integer type = 1;
    transient Bundle picBundle = new Bundle();

    public PicInfo setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
        return this;
    }

    public PicInfo setPic(Icon pic) {
        this.pic = "miui.focus.pic_mark_v2";
        picBundle.putParcelable("miui.focus.pic_mark_v2", pic);
        return this;
    }

    public PicInfo setType(Integer type) {
        this.type = type;
        return this;
    }

    public PicInfo setMyPic(String key, Icon myPic) {
        picBundle.putParcelable("miui.focus.pic_" + key, myPic);
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PicInfo picInfo)) return false;
        return Objects.equals(actionInfo, picInfo.actionInfo) && Objects.equals(pic, picInfo.pic) && Objects.equals(type, picInfo.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionInfo, pic, type);
    }

    @Override
    public String toString() {
        return "PicInfo{" +
            "actionInfo=" + actionInfo +
            ", pic='" + pic + '\'' +
            ", type=" + type +
            '}';
    }
}
