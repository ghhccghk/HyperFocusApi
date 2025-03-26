package com.hyperfocus.api;

import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import org.json.JSONException;
import org.json.JSONObject;

@RequiresApi(api = Build.VERSION_CODES.M)
public class HyperFocusNotify {
    private final NotificationCompat.Builder mNotifyBuilder;

    private String title = "";
    private String ticker = "";
    private String content = null;
    private String aodTitle = null;
    private String subTitle = null;
    private String subContent = null;
    private String extraTitle = null;
    private String specialTitle = null;
    private String desc1 = null;
    private String desc2 = null;
    private String colorSubTitle = "#000000";
    private String colorSubTitleDark = "#000000";
    private String colorSubContent = "#000000";
    private String colorSubContentDark = null;
    private String colorContent = "#000000";
    private String colorContentDark = null;
    private String colorTitle = "#000000";
    private String colorTitleDark = null;
    private String colorExtraTitle = "#000000";
    private String colorExtraTitleDark = null;
    private String colorSpecialTitle = "#000000";
    private String colorSpecialTitleDark = null;
    private String colorSpecialTitleBg = "#000000";
    private Icon picTicker;
    private Icon picTickerDark = null;
    private Icon picMarkV2 = null;
    private String aodPic = null;
    private Icon picBg = null;
    private int picBgType = 1;
    private int baseType = 1;
    private int protocol = 1;
    private int picMarkV2Type = 1;
    private Integer timeout = 280;
    private Integer normalHeight = null;
    private boolean updatable = true;
    private boolean enableFloat = false;
    private boolean padding = false;

    // 私有构造函数
    private HyperFocusNotify(NotificationCompat.Builder builder) {
        this.mNotifyBuilder = builder;
    }

    /**
     * 组装 Bundle 的过程：
     * 1. 构造 baseInfo JSON（基础通知信息）。
     * 2. 构造 param_v2 JSON（扩展通知参数），包括状态栏图标、背景图、右侧标志、aod参数等。
     * 3. 将图片相关 Bundle 与 JSON 数据放入最终 Bundle 中，并添加到 notifyBuilder 的 extras 中。
     *
     * @return 构建好的 Bundle
     */
    private Bundle buildBundle() {
        Bundle paramBundle = new Bundle();
        Bundle pics = new Bundle();
        JSONObject param = new JSONObject();
        JSONObject param_v2 = new JSONObject();
        JSONObject baseInfo = new JSONObject();

        try {
            // 填充 baseInfo
            baseInfo.put("title", title);
            baseInfo.put("colorTitle", colorTitle);
            baseInfo.put("type", baseType);
            if (colorTitleDark != null) {
                baseInfo.put("colorTitleDark", colorTitleDark);
            }
            if (content != null) {
                baseInfo.put("content", content);
                baseInfo.put("colorContent", colorContent);
                if (colorContentDark != null) {
                    baseInfo.put("colorContentDark", colorContentDark);
                }
            }
            if (subContent != null) {
                baseInfo.put("subContent", subContent);
                baseInfo.put("colorSubContent", colorSubContent);
                if (colorSubContentDark != null) {
                    baseInfo.put("colorSubContentDark", colorSubContentDark);
                }
            }
            if (extraTitle != null) {
                baseInfo.put("extraTitle", extraTitle);
                baseInfo.put("colorExtraTitle", colorExtraTitle);
                if (colorExtraTitleDark != null) {
                    baseInfo.put("colorExtraTitleDark", colorExtraTitleDark);
                }
            }
            if (specialTitle != null) {
                baseInfo.put("specialTitle", specialTitle);
                baseInfo.put("colorSpecialTitle", colorSpecialTitle);
                if (colorSpecialTitleDark != null) {
                    baseInfo.put("colorSpecialTitleDark", colorSpecialTitleDark);
                }
                baseInfo.put("colorSpecialTitleBg", colorSpecialTitleBg);
            }
            if (subTitle != null) {
                baseInfo.put("subTitle", subTitle);
                baseInfo.put("colorSubTitle", colorSubTitle);
                if (colorSubTitleDark != null) {
                    baseInfo.put("colorSubTitleDark", colorSubTitleDark);
                }
            }
            if (desc1 != null) {
                baseInfo.put("desc1", desc1);
            }
            if (desc2 != null) {
                baseInfo.put("desc2", desc2);
            }

            // 填充 param_v2
            param_v2.put("protocol", protocol);
            param_v2.put("enableFloat", enableFloat);
            param_v2.put("ticker", ticker);
            param_v2.put("tickerPic", "miui.focus.pic_ticker");
            param_v2.put("updatable", updatable);
            param_v2.put("padding", padding);
            if (normalHeight != null) {
                param_v2.put("normalHeight", normalHeight);
            }

            // 添加状态栏图标
            pics.putParcelable("miui.focus.pic_ticker", picTicker);
            if (picTickerDark != null) {
                param_v2.put("tickerPicDark", "miui.focus.pic_ticker_dark");
                pics.putParcelable("miui.focus.pic_ticker_dark", picTickerDark);
            }

            // 添加背景图片及参数
            if (picBg != null) {
                JSONObject bgInfo = new JSONObject();
                bgInfo.put("type", picBgType);
                bgInfo.put("picBg", "miui.focus.pic_bg");
                param_v2.put("bgInfo", bgInfo);
                pics.putParcelable("miui.focus.pic_bg", picBg);
            }

            // 添加右侧标志图片及参数
            if (picMarkV2 != null) {
                JSONObject picInfo = new JSONObject();
                picInfo.put("type", picMarkV2Type);
                picInfo.put("pic", "miui.focus.pic_mark_v2");
                param_v2.put("picInfo", picInfo);
                pics.putParcelable("miui.focus.pic_mark_v2", picMarkV2);
            }

            // aod相关信息
            if (aodTitle != null) {
                param_v2.put("aodTitle", title);
                if (aodPic != null) {
                    param_v2.put("aodPic", aodPic);
                }
            }
            // 超时参数
            if (timeout != null) {
                param_v2.put("timeout", timeout);
            }

            // 整合 Bundle 数据
            paramBundle.putBundle("miui.focus.pics", pics);
            param_v2.put("baseInfo", baseInfo);
            param.put("param_v2", param_v2);
            paramBundle.putString("miui.focus.param", param.toString());

            // 将参数添加到通知构造器中
            mNotifyBuilder.addExtras(paramBundle);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return paramBundle;
    }

    /**
     * 静态工厂方法，传入 NotificationCompat.Builder 后返回 Builder 实例
     */
    public static Builder builder(NotificationCompat.Builder builder) {
        return new Builder(new HyperFocusNotify(builder));
    }

    /**
     * 内部 Builder 类，提供链式调用设置各项参数
     */
    public static class Builder {
        private final HyperFocusNotify hyperFocusNotify;

        private Builder(HyperFocusNotify hyperFocusNotify) {
            this.hyperFocusNotify = hyperFocusNotify;
        }

        public Builder setTitle(String title) {
            hyperFocusNotify.title = title;
            return this;
        }

        public Builder setTicker(String ticker) {
            hyperFocusNotify.ticker = ticker;
            return this;
        }

        public Builder setContent(String content) {
            hyperFocusNotify.content = content;
            return this;
        }

        public Builder setAodTitle(String aodTitle) {
            hyperFocusNotify.aodTitle = aodTitle;
            return this;
        }

        public Builder setSubTitle(String subTitle) {
            hyperFocusNotify.subTitle = subTitle;
            return this;
        }

        public Builder setSubContent(String subContent) {
            hyperFocusNotify.subContent = subContent;
            return this;
        }

        public Builder setExtraTitle(String extraTitle) {
            hyperFocusNotify.extraTitle = extraTitle;
            return this;
        }

        public Builder setSpecialTitle(String specialTitle) {
            hyperFocusNotify.specialTitle = specialTitle;
            return this;
        }

        public Builder setDesc1(String desc1) {
            hyperFocusNotify.desc1 = desc1;
            return this;
        }

        public Builder setDesc2(String desc2) {
            hyperFocusNotify.desc2 = desc2;
            return this;
        }

        public Builder setColorSubTitle(String colorSubTitle) {
            hyperFocusNotify.colorSubTitle = colorSubTitle;
            return this;
        }

        public Builder setColorSubTitleDark(String colorSubTitleDark) {
            hyperFocusNotify.colorSubTitleDark = colorSubTitleDark;
            return this;
        }

        public Builder setColorSubContent(String colorSubContent) {
            hyperFocusNotify.colorSubContent = colorSubContent;
            return this;
        }

        public Builder setColorSubContentDark(String colorSubContentDark) {
            hyperFocusNotify.colorSubContentDark = colorSubContentDark;
            return this;
        }

        public Builder setColorContent(String colorContent) {
            hyperFocusNotify.colorContent = colorContent;
            return this;
        }

        public Builder setColorContentDark(String colorContentDark) {
            hyperFocusNotify.colorContentDark = colorContentDark;
            return this;
        }

        public Builder setColorTitle(String colorTitle) {
            hyperFocusNotify.colorTitle = colorTitle;
            return this;
        }

        public Builder setColorTitleDark(String colorTitleDark) {
            hyperFocusNotify.colorTitleDark = colorTitleDark;
            return this;
        }

        public Builder setColorExtraTitle(String colorExtraTitle) {
            hyperFocusNotify.colorExtraTitle = colorExtraTitle;
            return this;
        }

        public Builder setColorExtraTitleDark(String colorExtraTitleDark) {
            hyperFocusNotify.colorExtraTitleDark = colorExtraTitleDark;
            return this;
        }

        public Builder setColorSpecialTitle(String colorSpecialTitle) {
            hyperFocusNotify.colorSpecialTitle = colorSpecialTitle;
            return this;
        }

        public Builder setColorSpecialTitleDark(String colorSpecialTitleDark) {
            hyperFocusNotify.colorSpecialTitleDark = colorSpecialTitleDark;
            return this;
        }

        public Builder setColorSpecialTitleBg(String colorSpecialTitleBg) {
            hyperFocusNotify.colorSpecialTitleBg = colorSpecialTitleBg;
            return this;
        }

        public Builder setPicTicker(Icon picTicker) {
            hyperFocusNotify.picTicker = picTicker;
            return this;
        }

        public Builder setPicTickerDark(Icon picTickerDark) {
            hyperFocusNotify.picTickerDark = picTickerDark;
            return this;
        }

        public Builder setPicMarkV2(Icon picMarkV2) {
            hyperFocusNotify.picMarkV2 = picMarkV2;
            return this;
        }

        public Builder setAodPic(String aodPic) {
            hyperFocusNotify.aodPic = aodPic;
            return this;
        }

        public Builder setPicBg(Icon picBg) {
            hyperFocusNotify.picBg = picBg;
            return this;
        }

        public Builder setPicBgType(int picBgType) {
            hyperFocusNotify.picBgType = picBgType;
            return this;
        }

        public Builder setBaseType(int basetype) {
            hyperFocusNotify.baseType = basetype;
            return this;
        }

        public Builder setProtocol(int protocol) {
            hyperFocusNotify.protocol = protocol;
            return this;
        }

        public Builder setPicMarkV2Type(int picMarkV2Type) {
            hyperFocusNotify.picMarkV2Type = picMarkV2Type;
            return this;
        }

        public Builder setTimeout(Integer timeout) {
            hyperFocusNotify.timeout = timeout;
            return this;
        }

        public Builder setNormalHeight(Integer normalHeight) {
            hyperFocusNotify.normalHeight = normalHeight;
            return this;
        }

        public Builder setUpdatable(boolean updatable) {
            hyperFocusNotify.updatable = updatable;
            return this;
        }

        public Builder setEnableFloat(boolean enableFloat) {
            hyperFocusNotify.enableFloat = enableFloat;
            return this;
        }

        public Builder setPadding(boolean padding) {
            hyperFocusNotify.padding = padding;
            return this;
        }

        /**
         * 构建 Bundle，同时将参数添加到传入的 NotificationCompat.Builder 中
         *
         * @return 构造好的 Bundle
         */
        public Bundle build() {
            return hyperFocusNotify.buildBundle();
        }
    }
}