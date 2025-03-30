package com.hyperfocus.api.info;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import com.hyperfocus.api.FocusNotifyApi;

import java.util.List;
import java.util.Objects;

public final class Template {
    private List<ActionInfo> actions;
    private String aodPic;
    private String aodTitle;
    private BaseInfo baseInfo;
    private BgInfo bgInfo;
    private ChatInfo chatInfo;
    private boolean enableFloat;
    private HighlightInfo highlightInfo;
    private HintInfo hintInfo;
    private PicInfo picInfo;
    private ProgressInfo progressInfo;
    private String reopen;
    private boolean showSmallIcon;
    private String ticker;
    private String tickerPic;
    private String tickerPicDark;
    private int timeout;
    private boolean updatable;
    private transient final FocusNotifyApi focusNotifyApi;
    private transient final Bundle picBundle;

    public Template(Bundle picBundle, FocusNotifyApi focusNotifyApi) {
        this.picBundle = picBundle;
        this.focusNotifyApi = focusNotifyApi;
    }

    public Template setActions(List<ActionInfo> actions) {
        this.actions = actions;
        return this;
    }

    public Template setAodPic(Icon aodPic) {
        this.aodPic = "miui.focus.pic_aod";
        picBundle.putParcelable("miui.focus.pic_aod", aodPic);
        return this;
    }

    public Template setAodTitle(String aodTitle) {
        this.aodTitle = aodTitle;
        return this;
    }

    public Template setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
        return this;
    }

    public Template setBgInfo(BgInfo bgInfo) {
        this.bgInfo = bgInfo;
        picBundle.putAll(bgInfo.picBundle);
        return this;
    }

    public Template setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
        picBundle.putAll(chatInfo.picBundle);
        return this;
    }

    public Template setEnableFloat(boolean enableFloat) {
        this.enableFloat = enableFloat;
        return this;
    }

    public Template setHighlightInfo(HighlightInfo highlightInfo) {
        this.highlightInfo = highlightInfo;
        return this;
    }

    public Template setHintInfo(HintInfo hintInfo) {
        this.hintInfo = hintInfo;
        return this;
    }

    public Template setPicInfo(PicInfo picInfo) {
        this.picInfo = picInfo;
        picBundle.putAll(picInfo.picBundle);
        return this;
    }

    public Template setProgressInfo(ProgressInfo progressInfo) {
        this.progressInfo = progressInfo;
        return this;
    }

    public Template setReopen(String reopen) {
        this.reopen = reopen;
        return this;
    }

    public Template setShowSmallIcon(boolean showSmallIcon) {
        this.showSmallIcon = showSmallIcon;
        return this;
    }

    public Template setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public Template setTickerPic(Icon tickerPic) {
        this.tickerPic = "miui.focus.pic_ticker";
        picBundle.putParcelable("miui.focus.pic_ticker", tickerPic);
        return this;
    }

    public Template setTickerPicDark(Icon tickerPicDark) {
        this.tickerPicDark = "miui.focus.pic_ticker_dark";
        picBundle.putParcelable("miui.focus.pic_ticker_dark", tickerPicDark);
        return this;
    }

    public Template setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public Template setUpdatable(boolean updatable) {
        this.updatable = updatable;
        return this;
    }

    public Bundle create() {
        return focusNotifyApi.create(picBundle);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Template template)) return false;
        return enableFloat == template.enableFloat && showSmallIcon == template.showSmallIcon && timeout == template.timeout && updatable == template.updatable && Objects.equals(actions, template.actions) && Objects.equals(aodPic, template.aodPic) && Objects.equals(aodTitle, template.aodTitle) && Objects.equals(baseInfo, template.baseInfo) && Objects.equals(bgInfo, template.bgInfo) && Objects.equals(chatInfo, template.chatInfo) && Objects.equals(highlightInfo, template.highlightInfo) && Objects.equals(hintInfo, template.hintInfo) && Objects.equals(picInfo, template.picInfo) && Objects.equals(progressInfo, template.progressInfo) && Objects.equals(reopen, template.reopen) && Objects.equals(ticker, template.ticker) && Objects.equals(tickerPic, template.tickerPic) && Objects.equals(tickerPicDark, template.tickerPicDark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actions, aodPic, aodTitle, baseInfo, bgInfo, chatInfo, enableFloat, highlightInfo, hintInfo, picInfo, progressInfo, reopen, showSmallIcon, ticker, tickerPic, tickerPicDark, timeout, updatable);
    }

    @Override
    public String toString() {
        return "Template{" +
            "actions=" + actions +
            ", aodPic='" + aodPic + '\'' +
            ", aodTitle='" + aodTitle + '\'' +
            ", baseInfo=" + baseInfo +
            ", bgInfo=" + bgInfo +
            ", chatInfo=" + chatInfo +
            ", enableFloat=" + enableFloat +
            ", highlightInfo=" + highlightInfo +
            ", hintInfo=" + hintInfo +
            ", picInfo=" + picInfo +
            ", progressInfo=" + progressInfo +
            ", reopen='" + reopen + '\'' +
            ", showSmallIcon=" + showSmallIcon +
            ", ticker='" + ticker + '\'' +
            ", tickerPic='" + tickerPic + '\'' +
            ", tickerPicDark='" + tickerPicDark + '\'' +
            ", timeout=" + timeout +
            ", updatable=" + updatable +
            '}';
    }
}
