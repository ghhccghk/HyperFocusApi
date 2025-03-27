package com.hyperfocus.api;

import org.json.JSONObject;

/**
 * Builder for constructing the HintInfo JSON object.
 * 用于描述通知中的提示信息，包括图标、标题及其颜色设置等。
 */
public class HintInfo {
    private JSONObject hintInfo;

    JSONObject getHintInfo() {
        return hintInfo;
    }

    private HintInfo setHintInfo(JSONObject hintInfo) {
        this.hintInfo = hintInfo;
        return this;
    }

    public static class Builder {
        private String colorContentBg;
        private int type = 1;
        private String picContent;
        private JSONObject timerInfo;
        private String title;
        private String colorTitle = "#000000";
        private String colorTitleDark;
        private Integer titleLineCount;

        /**
         * 设置提示内容背景颜色。
         *
         * @param colorContentBg 背景颜色字符串
         * @return Builder 实例
         */
        public Builder setColorContentBg(String colorContentBg) {
            this.colorContentBg = colorContentBg;
            return this;
        }

        /**
         * 设置提示信息类型。
         *
         * @param type 类型标志
         * @return Builder 实例
         */
        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        /**
         * 设置提示图标标识。
         *
         * @param picContent 图标标识字符串
         * @return Builder 实例
         */
        public Builder setPicContent(String picContent) {
            this.picContent = picContent;
            return this;
        }

        /**
         * 设置时间信息 JSON 对象。
         *
         * @param timerInfo 时间信息 JSONObject
         * @return Builder 实例
         */
        public Builder setTimerInfo(JSONObject timerInfo) {
            this.timerInfo = timerInfo;
            return this;
        }

        /**
         * 设置提示标题。
         *
         * @param title 标题字符串
         * @return Builder 实例
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * 设置提示标题颜色。
         *
         * @param colorTitle 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorTitle(String colorTitle) {
            this.colorTitle = colorTitle;
            return this;
        }

        /**
         * 设置提示标题深色颜色。
         *
         * @param colorTitleDark 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorTitleDark(String colorTitleDark) {
            this.colorTitleDark = colorTitleDark;
            return this;
        }

        /**
         * 设置标题行数。
         *
         * @param titleLineCount 标题行数
         * @return Builder 实例
         */
        public Builder setTitleLineCount(Integer titleLineCount) {
            this.titleLineCount = titleLineCount;
            return this;
        }

        /**
         * 构建 HintInfo 的 JSONObject 对象。
         *
         * @return JSONObject 对象，包含提示信息
         */
        public HintInfo build() {
            JSONObject hintInfo = new JSONObject();
            try {
                if (colorContentBg != null) {
                    hintInfo.put("colorContentBg", colorContentBg);
                }
                if (picContent != null) {
                    hintInfo.put("picContent", picContent);
                }
                if (timerInfo != null) {
                    hintInfo.put("timerInfo", timerInfo);
                }
                if (title != null) {
                    hintInfo.put("title", title);
                    hintInfo.put("colorTitle", colorTitle);
                    if (colorTitleDark != null) {
                        hintInfo.put("colortitleDark", colorTitleDark);
                    }
                }
                if (titleLineCount != null) {
                    hintInfo.put("titleLineCount", titleLineCount);
                }
                hintInfo.put("type", type);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new HintInfo().setHintInfo(hintInfo);
        }
    }
}
