package com.hyperfocus.api;

import android.annotation.SuppressLint;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;

import org.json.JSONObject;

/**
 * FocusApi 用于构建焦点通知的参数 Bundle，并添加到 NotificationCompat.Builder 中。
 * 使用 Builder 模式进行参数设置，同时提供了多个辅助 Builder 用于构建各类 JSON 对象。
 */
public class HyperFocusNotify {
    private final Bundle paramsBundle;

    private HyperFocusNotify(Bundle paramsBundle) {
        this.paramsBundle = paramsBundle;
    }

    /**
     * 获取构建好的参数 Bundle。
     *
     * @return Bundle 包含所有焦点通知参数
     */
    public Bundle getParamsBundle() {
        return paramsBundle;
    }

    /**
     * 将焦点通知参数添加到指定的 NotificationCompat.Builder 中。
     *
     * @param builder NotificationCompat.Builder 对象
     */
    public void applyTo(NotificationCompat.Builder builder) {
        builder.addExtras(paramsBundle);
    }

    /**
     * FocusApi 的 Builder 内部类，用于逐步构建 FocusApi 对象。
     */
    public static class Builder {
        private BaseInfo baseInfo;
        private HighlightInfo highlightInfo;
        private HintInfo hintInfo;
        private ChatInfo chatInfo;
        private String scene = "templateBaseScene";
        private String title;
        private String colorTitle = "#000000";
        private String content;
        private String ticker;
        private String aodTitle;
        private Icon tickerPic;
        private Icon tickerPicDark;
        private Icon picMarkV2;
        private Icon picProfile;
        private Icon aodPic;
        private Icon picBg;
        private Bundle additionalPics;
        private Icon picFunction;
        private int picBgType = 1;
        private int protocol = 1;
        private int picMarkV2Type = 1;
        private Integer timeout = 280;
        private Integer normalHeight;
        private boolean updatable = true;
        private boolean enableFloat = false;
        private boolean padding = false;

        /**
         * 设置基础信息 JSON 对象。
         *
         * @param baseInfo 包含基础信息的 JSON 对象
         * @return Builder 实例
         */
        public Builder setBaseInfo(BaseInfo baseInfo) {
            this.baseInfo = baseInfo;
            return this;
        }

        /**
         * 设置高亮信息 JSON 对象。
         *
         * @param highlightInfo 包含高亮信息的 JSON 对象
         * @return Builder 实例
         */
        public Builder setHighlightInfo(HighlightInfo highlightInfo) {
            this.highlightInfo = highlightInfo;
            return this;
        }

        /**
         * 设置提示信息 JSON 对象。
         *
         * @param hintInfo 包含提示信息的 JSON 对象
         * @return Builder 实例
         */
        public Builder setHintInfo(HintInfo hintInfo) {
            this.hintInfo = hintInfo;
            return this;
        }

        /**
         * 设置聊天信息 JSON 对象。
         *
         * @param chatInfo 包含聊天信息的 JSON 对象
         * @return Builder 实例
         */
        public Builder setChatInfo(ChatInfo chatInfo) {
            this.chatInfo = chatInfo;
            return this;
        }

        /**
         * 设置场景信息。
         *
         * @param scene 场景字符串
         * @return Builder 实例
         */
        public Builder setScene(String scene) {
            this.scene = scene;
            return this;
        }

        /**
         * 设置焦点通知标题。
         *
         * @param title 标题字符串
         * @return Builder 实例
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * 设置标题颜色。
         *
         * @param colorTitle 颜色字符串（如 "#000000"）
         * @return Builder 实例
         */
        public Builder setColorTitle(String colorTitle) {
            this.colorTitle = colorTitle;
            return this;
        }

        /**
         * 设置焦点通知内容。
         *
         * @param content 内容字符串
         * @return Builder 实例
         */
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * 设置状态栏 ticker 文本。
         *
         * @param ticker ticker 文本
         * @return Builder 实例
         */
        public Builder setTicker(String ticker) {
            this.ticker = ticker;
            return this;
        }

        /**
         * 设置息屏时显示的标题。
         *
         * @param aodTitle 息屏标题
         * @return Builder 实例
         */
        public Builder setAodTitle(String aodTitle) {
            this.aodTitle = aodTitle;
            return this;
        }

        /**
         * 设置状态栏浅色图标。
         *
         * @param tickerPic 浅色图标
         * @return Builder 实例
         */
        public Builder setTickerPic(Icon tickerPic) {
            this.tickerPic = tickerPic;
            return this;
        }

        /**
         * 设置状态栏深色图标。
         *
         * @param tickerPicDark 深色图标
         * @return Builder 实例
         */
        public Builder setTickerPicDark(Icon tickerPicDark) {
            this.tickerPicDark = tickerPicDark;
            return this;
        }

        /**
         * 设置焦点通知右侧标志图标（版本2）。
         *
         * @param picMarkV2 图标
         * @return Builder 实例
         */
        public Builder setPicMarkV2(Icon picMarkV2) {
            this.picMarkV2 = picMarkV2;
            return this;
        }

        /**
         * 设置聊天头像图标。
         *
         * @param picProfile 聊天头像图标
         * @return Builder 实例
         */
        public Builder setPicProfile(Icon picProfile) {
            this.picProfile = picProfile;
            return this;
        }

        /**
         * 设置息屏图标。
         *
         * @param aodPic 息屏图标
         * @return Builder 实例
         */
        public Builder setAodPic(Icon aodPic) {
            this.aodPic = aodPic;
            return this;
        }

        /**
         * 设置通知背景图标。
         *
         * @param picBg 背景图标
         * @return Builder 实例
         */
        public Builder setPicBg(Icon picBg) {
            this.picBg = picBg;
            return this;
        }

        /**
         * 设置附加图片 Bundle。
         *
         * @param additionalPics 附加图片 Bundle
         * @return Builder 实例
         */
        public Builder setAdditionalPics(Bundle additionalPics) {
            this.additionalPics = additionalPics;
            return this;
        }

        /**
         * 设置通知功能图标。
         *
         * @param picFunction 功能图标
         * @return Builder 实例
         */
        public Builder setPicFunction(Icon picFunction) {
            this.picFunction = picFunction;
            return this;
        }

        /**
         * 设置背景图标类型。
         *
         * @param picBgType 背景图标类型（如 1）
         * @return Builder 实例
         */
        public Builder setPicBgType(int picBgType) {
            this.picBgType = picBgType;
            return this;
        }

        /**
         * 设置协议版本。
         *
         * @param protocol 协议版本
         * @return Builder 实例
         */
        public Builder setProtocol(int protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * 设置焦点通知右侧标志类型（版本2）。
         *
         * @param picMarkV2Type 标志类型
         * @return Builder 实例
         */
        public Builder setPicMarkV2Type(int picMarkV2Type) {
            this.picMarkV2Type = picMarkV2Type;
            return this;
        }

        /**
         * 设置焦点通知超时时间。
         *
         * @param timeout 超时时间（秒）
         * @return Builder 实例
         */
        public Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * 设置焦点通知的默认高度。
         *
         * @param normalHeight 高度数值
         * @return Builder 实例
         */
        public Builder setNormalHeight(int normalHeight) {
            this.normalHeight = normalHeight;
            return this;
        }

        /**
         * 设置焦点通知是否支持更新。
         *
         * @param updatable true 表示可更新，false 表示不可更新
         * @return Builder 实例
         */
        public Builder setUpdatable(boolean updatable) {
            this.updatable = updatable;
            return this;
        }

        /**
         * 设置焦点通知是否可以悬浮显示。
         *
         * @param enableFloat true 表示可以悬浮，false 表示不可以
         * @return Builder 实例
         */
        public Builder setEnableFloat(boolean enableFloat) {
            this.enableFloat = enableFloat;
            return this;
        }

        /**
         * 设置焦点通知的内边距开关。
         *
         * @param padding true 表示启用内边距，false 表示禁用
         * @return Builder 实例
         */
        public Builder setPadding(boolean padding) {
            this.padding = padding;
            return this;
        }

        /**
         * 构建 FocusApi 对象。
         *
         * @return 构建好的 FocusApi 对象，内部包含生成的参数 Bundle
         */
        @SuppressLint("NewApi")
        public HyperFocusNotify build() {
            Bundle paramsBundle = new Bundle();
            Bundle picsBundle = new Bundle();
            JSONObject param = new JSONObject();
            JSONObject paramV2 = new JSONObject();

            try {
                // 设置基础参数到 paramV2
                paramV2.put("protocol", protocol);
                paramV2.put("enableFloat", enableFloat);
                paramV2.put("ticker", ticker);
                paramV2.put("tickerPic", "miui.focus.pic_ticker");
                paramV2.put("updatable", updatable);
                paramV2.put("padding", padding);

                if (content != null) {
                    param.put("content", content);
                }
                if (title != null) {
                    param.put("title", title);
                    param.put("colorTitle", colorTitle);
                    paramV2.put("colorTitle", colorTitle);
                }
                param.put("scene", scene);

                // 添加状态栏图标
                picsBundle.putParcelable("miui.focus.pic_ticker", tickerPic);

                if (normalHeight != null) {
                    paramV2.put("normalHeight", normalHeight);
                }

                if (tickerPicDark != null) {
                    paramV2.put("tickerPicDark", "miui.focus.pic_ticker_dark");
                    picsBundle.putParcelable("miui.focus.pic_ticker_dark", tickerPicDark);
                }
                if (picBg != null) {
                    JSONObject bgInfo = new JSONObject();
                    bgInfo.put("type", picBgType);
                    bgInfo.put("picBg", "miui.focus.pic_bg");
                    paramV2.put("bgInfo", bgInfo);
                    picsBundle.putParcelable("miui.focus.pic_bg", picBg);
                }
                if (picMarkV2 != null) {
                    JSONObject picInfo = new JSONObject();
                    picInfo.put("type", picMarkV2Type);
                    picInfo.put("pic", "miui.focus.pic_mark_v2");
                    paramV2.put("picInfo", picInfo);
                    picsBundle.putParcelable("miui.focus.pic_mark_v2", picMarkV2);
                }
                if (aodTitle != null) {
                    paramV2.put("aodTitle", aodTitle);
                    if (aodPic != null) {
                        picsBundle.putParcelable("miui.focus.pic_aod", aodPic);
                        paramV2.put("aodPic", "miui.focus.pic_aod");
                    }
                }
                if (timeout != null) {
                    paramV2.put("timeout", timeout);
                }
                if (highlightInfo != null) {
                    paramV2.put("highlightInfo", highlightInfo.getHighlightInfo());
                }
                if (picFunction != null) {
                    picsBundle.putParcelable("miui.focus.pic_notification", picFunction);
                }
                if (picProfile != null) {
                    picsBundle.putParcelable("miui.focus.pic_profile", picProfile);
                }
                if (chatInfo != null) {
                    paramV2.put("chatInfo", chatInfo.getChatInfo());
                }
                if (hintInfo != null) {
                    paramV2.put("hintInfo", hintInfo.getHintInfo());
                }
                if (additionalPics != null) {
                    picsBundle.putAll(additionalPics);
                }

                paramsBundle.putBundle("miui.focus.pics", picsBundle);

                if (baseInfo != null) {
                    paramV2.put("baseInfo", baseInfo.getBaseInfo());
                }
                param.put("param_v2", paramV2);
                paramsBundle.putString("miui.focus.param", param.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new HyperFocusNotify(paramsBundle);
        }
    }

    /**
     * 辅助方法：添加单个图片到 Bundle 中。
     *
     * @param name 图片名称标识
     * @param icon 图标对象
     * @return Bundle 包含该图片
     */
    @SuppressLint("NewApi")
    public static Bundle addPicture(String name, Icon icon) {
        Bundle pics = new Bundle();
        String key = "miui.focus.pic_" + name;
        pics.putParcelable(key, icon);
        return pics;
    }
}
