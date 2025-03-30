package com.hyperfocus.api.info;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import java.util.Objects;

public final class BgInfo {
    private String colorBg;
    private String picBg;
    private int type;
    transient Bundle picBundle = new Bundle();

    public BgInfo setColorBg(String colorBg) {
        this.colorBg = colorBg;
        return this;
    }

    public BgInfo setPicBg(Icon picBg) {
        this.picBg = "miui.focus.pic_bg";
        picBundle.putParcelable("miui.focus.pic_bg", picBg);
        return this;
    }

    public BgInfo setType(int type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof BgInfo bgInfo)) return false;
        return type == bgInfo.type && Objects.equals(colorBg, bgInfo.colorBg) && Objects.equals(picBg, bgInfo.picBg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorBg, picBg, type);
    }

    @Override
    public String toString() {
        return "BgInfo{" +
            "colorBg='" + colorBg + '\'' +
            ", picBg='" + picBg + '\'' +
            ", type=" + type +
            '}';
    }
}
