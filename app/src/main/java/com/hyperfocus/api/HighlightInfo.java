package com.hyperfocus.api;

import org.json.JSONObject;

public class HighlightInfo {
    private JSONObject highlightInfo;

    JSONObject getHighlightInfo() {
        return highlightInfo;
    }

    private HighlightInfo setHighlightInfo(JSONObject highlightInfo) {
        this.highlightInfo = highlightInfo;
        return this;
    }

    public static class Builder {
        private int type = 1;
        private JSONObject timerInfo;
        private String title;
        private String subContent;
        private String colorSubContent = "#000000";
        private String colorSubContentDark;

        /**
         * 设置高亮信息的类型标志。
         *
         * @param type 类型标志，默认为 1
         * @return Builder 实例
         */
        public Builder setType(int type) {
            this.type = type;
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
         * 设置高亮信息的标题。
         *
         * @param title 标题字符串
         * @return Builder 实例
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * 设置高亮信息的小标题。
         *
         * @param subContent 小标题字符串
         * @return Builder 实例
         */
        public Builder setSubContent(String subContent) {
            this.subContent = subContent;
            return this;
        }

        /**
         * 设置小标题颜色，同时用于标题颜色（colorTitle）。
         *
         * @param colorSubContent 颜色字符串，默认为 "#000000"
         * @return Builder 实例
         */
        public Builder setColorSubContent(String colorSubContent) {
            this.colorSubContent = colorSubContent;
            return this;
        }

        /**
         * 设置小标题深色颜色。
         *
         * @param colorSubContentDark 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorSubContentDark(String colorSubContentDark) {
            this.colorSubContentDark = colorSubContentDark;
            return this;
        }

        /**
         * 构建高亮信息的 JSONObject 对象。
         *
         * @return JSONObject 对象，包含高亮信息
         */
        public HighlightInfo build() {
            JSONObject highlightInfo = new JSONObject();
            try {
                highlightInfo.put("type", type);
                highlightInfo.put("timerInfo", timerInfo);
                if (title != null) {
                    highlightInfo.put("title", title);
                }
                // 按原逻辑，将 colorSubContent 同时设置为 colorTitle
                highlightInfo.put("colorTitle", colorSubContent);
                if (subContent != null) {
                    highlightInfo.put("subContent", subContent);
                    highlightInfo.put("colorSubContent", colorSubContent);
                    if (colorSubContentDark != null) {
                        highlightInfo.put("colorSubContentDark", colorSubContentDark);
                    }
                    highlightInfo.put("picFunction", "miui.focus.pic_notification");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new HighlightInfo().setHighlightInfo(highlightInfo);
        }
    }
}
