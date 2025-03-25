package com.hyperfocus.api;

import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import org.json.JSONException;
import org.json.JSONObject;

public class HyperFocusNotify {
    private static Builder mBuilder;
    private final Bundle mParamBundle = new Bundle();
    private final Bundle mPicsBundle = new Bundle();
    private final JSONObject mParam = new JSONObject();
    private final JSONObject mParam_v2 = new JSONObject();
    private final JSONObject mBaseInfo = new JSONObject();

    private HyperFocusNotify() {
    }

    public static Builder builder(NotificationCompat.Builder builder) {
        return mBuilder = new Builder(new HyperFocusNotify(), builder);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private Bundle create() {
        try {
            mBaseInfo.put("title", mBuilder.mTitle);
            mBaseInfo.put("colorTitle", mBuilder.mTitleColor);
            mBaseInfo.put("type", mBuilder.mBaseType);

            mParam_v2.put("protocol", mBuilder.mProtocol);
            mParam_v2.put("aodTitle", mBuilder.mTitle);
            mParam_v2.put("enableFloat", mBuilder.isEnableFloat);
            mParam_v2.put("ticker", mBuilder.mTicker);
            mParam_v2.put("tickerPic", "miui.focus.pic_ticker");
            mParam_v2.put("tickerPicDark", "miui.focus.pic_ticker_dark");
            mParam_v2.put("updatable", mBuilder.isUpdatable);

            if (mBuilder.mPicTicker != null)
                mPicsBundle.putParcelable("miui.focus.pic_ticker", mBuilder.mPicTicker);
            if (mBuilder.mPicTickerDark != null)
                mPicsBundle.putParcelable("miui.focus.pic_ticker_dark", mBuilder.mPicTickerDark);
            if (mBuilder.mPicBg != null) {
                JSONObject bgInfo = new JSONObject();
                bgInfo.put("type", mBuilder.mPicBgType);
                bgInfo.put("picBg", "miui.focus.pic_bg");
                mParam_v2.put("bgInfo", bgInfo);
                mPicsBundle.putParcelable("miui.focus.pic_bg", mBuilder.mPicBg);
            }

            if (mBuilder.mPicMarkV2 != null) {
                JSONObject picInfo = new JSONObject();
                picInfo.put("type", mBuilder.mPicMarkV2Type);
                picInfo.put("pic", "miui.focus.pic_mark_v2");
                mParam_v2.put("picInfo", picInfo);
                mPicsBundle.putParcelable("miui.focus.pic_mark_v2", mBuilder.mPicMarkV2);
            }

            mParamBundle.putBundle("miui.focus.pics", mPicsBundle);

            if (mBuilder.mContent != null) {
                mBaseInfo.put("content", mBuilder.mContent);
                mBaseInfo.put("colorContent", mBuilder.mContentColor);
            }
            if (mBuilder.mSubContent != null) {
                mBaseInfo.put("subContent", mBuilder.mSubContent);
                mBaseInfo.put("colorSubContent", mBuilder.mSubContentColor);
            }

            mParam_v2.put("baseInfo", mBaseInfo);
            mParam.put("param_v2", mParam_v2);
            mParamBundle.putString("miui.focus.param", mParam.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        mBuilder.mNotifyBuilder.addExtras(mParamBundle);
        return mParamBundle;
    }

    public static class Builder {
        private final HyperFocusNotify mHyperFocusNotify;
        private final NotificationCompat.Builder mNotifyBuilder;
        private String mTicker = "";
        private String mTitle = "";
        private String mTitleColor = "#000000";
        private String mContent;
        private String mContentColor = "#000000";
        private String mSubContent;
        private String mSubContentColor = "#000000";
        private Icon mPicTicker;
        private Icon mPicTickerDark;
        private Icon mPicBg;
        private Icon mPicMarkV2;
        private int mPicBgType = 1;
        private int mPicMarkV2Type = 1;
        private int mBaseType = 1;
        private int mProtocol = 1;
        private boolean isUpdatable = true;
        private boolean isEnableFloat = false;

        private Builder(HyperFocusNotify hyperFocusNotify, NotificationCompat.Builder builder) {
            mHyperFocusNotify = hyperFocusNotify;
            mNotifyBuilder = builder;
        }

        /**
         * 标题
         * */
        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        /**
         * 标题颜色
         * */
        public Builder setTitleColor(String titleColor) {
            mTitleColor = titleColor;
            return this;
        }

        /**
         * 小标题
         * */
        public Builder setContent(String content) {
            mContent = content;
            return this;
        }

        /**
         * 小标题颜色
         */
        public Builder setContentColor(String contentColor) {
            mContentColor = contentColor;
            return this;
        }

        /**
         * 小标题边上的小标题
         */
        public Builder setSubContent(String subContent) {
            mSubContent = subContent;
            return this;
        }

        /**
         * 小标题边上的小标题颜色
         * */
        public Builder setSubContentColor(String subContentColor) {
            mSubContentColor = subContentColor;
            return this;
        }

        /**
         * 状态栏内容
         * */
        public Builder setTicker(String ticker) {
            mTicker = ticker;
            return this;
        }

        /**
         * 状态栏图标
         * */
        public Builder setPicTicker(Icon picTicker) {
            mPicTicker = picTicker;
            return this;
        }

        /**
         * 深色模式下状态栏图标
         */
        public Builder setPicTickerDark(Icon picTickerDark) {
            mPicTickerDark = picTickerDark;
            return this;
        }

        public Builder setPicBg(Icon picBg) {
            mPicBg = picBg;
            return this;
        }

        public Builder setPicBgType(int picBgType) {
            mPicBgType = picBgType;
            return this;
        }

        public Builder setPicMarkV2(Icon picMarkV2) {
            mPicMarkV2 = picMarkV2;
            return this;
        }

        public Builder setPicMarkV2Type(int picMarkV2Type) {
            mPicMarkV2Type = picMarkV2Type;
            return this;
        }

        public Builder setBaseType(int baseType) {
            mBaseType = baseType;
            return this;
        }

        public Builder setProtocol(int protocol) {
            mProtocol = protocol;
            return this;
        }

        public Builder setUpdatable(boolean updatable) {
            isUpdatable = updatable;
            return this;
        }

        public Builder setEnableFloat(boolean enableFloat) {
            isEnableFloat = enableFloat;
            return this;
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        public Bundle create() {
            return mHyperFocusNotify.create();
        }
    }
}
