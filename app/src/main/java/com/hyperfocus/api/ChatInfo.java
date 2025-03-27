package com.hyperfocus.api;

import org.json.JSONObject;

/**
 * Builder for constructing the ChatInfo JSON object.
 * 用于描述通知中的聊天信息，包括头像、标题、内容及其颜色设置。
 */
public class ChatInfo {
    private JSONObject chatInfo;

    JSONObject getChatInfo() {
        return chatInfo;
    }

    private ChatInfo setChatInfo(JSONObject chatInfo) {
        this.chatInfo = chatInfo;
        return this;
    }

    public static class Builder {
        private String picProfile = "miui.focus.pic_profile";
        private TimerInfo timerInfo;
        private String title;
        private String colorTitle = "#000000";
        private String colorTitleDark;
        private String content;
        private String colorContent = "#000000";
        private String colorContentDark;

        /**
         * 设置聊天头像标识。
         *
         * @param picProfile 头像标识字符串
         * @return Builder 实例
         */
        public Builder setPicProfile(String picProfile) {
            this.picProfile = picProfile;
            return this;
        }

        /**
         * 设置时间信息 JSON 对象。
         *
         * @param timerInfo 时间信息 JSONObject
         * @return Builder 实例
         */
        public Builder setTimerInfo(TimerInfo timerInfo) {
            this.timerInfo = timerInfo;
            return this;
        }

        /**
         * 设置聊天标题。
         *
         * @param title 聊天标题字符串
         * @return Builder 实例
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * 设置标题颜色。
         *
         * @param colorTitle 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorTitle(String colorTitle) {
            this.colorTitle = colorTitle;
            return this;
        }

        /**
         * 设置标题深色颜色。
         *
         * @param colorTitleDark 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorTitleDark(String colorTitleDark) {
            this.colorTitleDark = colorTitleDark;
            return this;
        }

        /**
         * 设置聊天内容。
         *
         * @param content 聊天内容字符串
         * @return Builder 实例
         */
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * 设置内容颜色。
         *
         * @param colorContent 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorContent(String colorContent) {
            this.colorContent = colorContent;
            return this;
        }

        /**
         * 设置内容深色颜色。
         *
         * @param colorContentDark 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorContentDark(String colorContentDark) {
            this.colorContentDark = colorContentDark;
            return this;
        }

        /**
         * 构建 ChatInfo 的 JSONObject 对象。
         *
         * @return JSONObject 对象，包含聊天信息
         */
        public ChatInfo build() {
            JSONObject chatInfo = new JSONObject();
            try {
                chatInfo.put("picProfile", picProfile);
                if (timerInfo != null) {
                    chatInfo.put("timerInfo", timerInfo.getTimerInfo());
                }
                chatInfo.put("title", title);
                chatInfo.put("colorTitle", colorTitle);
                if (colorTitleDark != null) {
                    chatInfo.put("colortitleDark", colorTitleDark);
                }
                chatInfo.put("content", content);
                chatInfo.put("colorContent", colorContent);
                if (colorContentDark != null) {
                    chatInfo.put("colorContentDark", colorContentDark);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ChatInfo().setChatInfo(chatInfo);
        }
    }
}
