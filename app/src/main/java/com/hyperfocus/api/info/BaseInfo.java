package com.hyperfocus.api.info;

import java.util.Objects;

public final class BaseInfo extends TextAndColorInfo {
    private String picFunction;
    private Boolean setMarginBottom;
    private Boolean setMarginTop;
    private Boolean showContentDivider;
    private Boolean showDivider;
    private Integer type = 1;

    public BaseInfo setPicFunction(String picFunction) {
        this.picFunction = "miui.focus.pic_" + picFunction;
        return this;
    }

    public BaseInfo setSetMarginBottom(Boolean setMarginBottom) {
        this.setMarginBottom = setMarginBottom;
        return this;
    }

    public BaseInfo setSetMarginTop(Boolean setMarginTop) {
        this.setMarginTop = setMarginTop;
        return this;
    }

    public BaseInfo setShowContentDivider(Boolean showContentDivider) {
        this.showContentDivider = showContentDivider;
        return this;
    }

    public BaseInfo setShowDivider(Boolean showDivider) {
        this.showDivider = showDivider;
        return this;
    }

    public BaseInfo setType(Integer type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof BaseInfo baseInfo)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(picFunction, baseInfo.picFunction) && Objects.equals(setMarginBottom, baseInfo.setMarginBottom) && Objects.equals(setMarginTop, baseInfo.setMarginTop) && Objects.equals(showContentDivider, baseInfo.showContentDivider) && Objects.equals(showDivider, baseInfo.showDivider) && Objects.equals(type, baseInfo.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), picFunction, setMarginBottom, setMarginTop, showContentDivider, showDivider, type);
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
            "picFunction='" + picFunction + '\'' +
            ", setMarginBottom=" + setMarginBottom +
            ", setMarginTop=" + setMarginTop +
            ", showContentDivider=" + showContentDivider +
            ", showDivider=" + showDivider +
            ", type=" + type +
            "} " + super.toString();
    }
}
