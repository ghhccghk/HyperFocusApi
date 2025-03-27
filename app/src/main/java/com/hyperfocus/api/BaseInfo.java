package com.hyperfocus.api;

import org.json.JSONObject;

/**
 * Builder for constructing the BaseInfo JSON object.
 * 包含通知的标题、内容、副标题、附加信息及对应颜色设置。
 */
public class BaseInfo {
    private JSONObject baseInfo;

    JSONObject getBaseInfo() {
        return baseInfo;
    }

    private BaseInfo setBaseInfo(JSONObject baseInfo) {
        this.baseInfo = baseInfo;
        return this;
    }

    public static class Builder {
        private String title;
        private String content;
        private String subTitle;
        private String subContent;
        private String extraTitle;
        private String specialTitle;
        private String desc1;
        private String desc2;
        private String colorSubTitle = "#000000";
        private String colorSubTitleDark;
        private String colorSubContent = "#000000";
        private String colorSubContentDark;
        private String colorContent = "#000000";
        private String colorContentDark;
        private String colorTitle = "#000000";
        private String colorTitleDark;
        private String colorExtraTitle = "#000000";
        private String colorExtraTitleDark;
        private String colorSpecialTitle = "#000000";
        private String colorSpecialTitleDark;
        private String colorSpecialTitleBg = "#000000";

        /**
         * 设置通知标题。
         *
         * @param title 标题字符串
         * @return Builder 实例
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * 设置通知内容。
         *
         * @param content 内容字符串
         * @return Builder 实例
         */
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * 设置通知副标题。
         *
         * @param subTitle 副标题字符串
         * @return Builder 实例
         */
        public Builder setSubTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        /**
         * 设置副标题旁的小标题。
         *
         * @param subContent 小标题字符串
         * @return Builder 实例
         */
        public Builder setSubContent(String subContent) {
            this.subContent = subContent;
            return this;
        }

        /**
         * 设置附加标题。
         *
         * @param extraTitle 附加标题字符串
         * @return Builder 实例
         */
        public Builder setExtraTitle(String extraTitle) {
            this.extraTitle = extraTitle;
            return this;
        }

        /**
         * 设置特殊标题。
         *
         * @param specialTitle 特殊标题字符串
         * @return Builder 实例
         */
        public Builder setSpecialTitle(String specialTitle) {
            this.specialTitle = specialTitle;
            return this;
        }

        /**
         * 设置描述信息1。
         *
         * @param desc1 描述1字符串
         * @return Builder 实例
         */
        public Builder setDesc1(String desc1) {
            this.desc1 = desc1;
            return this;
        }

        /**
         * 设置描述信息2。
         *
         * @param desc2 描述2字符串
         * @return Builder 实例
         */
        public Builder setDesc2(String desc2) {
            this.desc2 = desc2;
            return this;
        }

        /**
         * 设置副标题颜色。
         *
         * @param colorSubTitle 颜色字符串（如 "#000000"）
         * @return Builder 实例
         */
        public Builder setColorSubTitle(String colorSubTitle) {
            this.colorSubTitle = colorSubTitle;
            return this;
        }

        /**
         * 设置副标题深色颜色。
         *
         * @param colorSubTitleDark 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorSubTitleDark(String colorSubTitleDark) {
            this.colorSubTitleDark = colorSubTitleDark;
            return this;
        }

        /**
         * 设置小标题颜色。
         *
         * @param colorSubContent 颜色字符串
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
         * 设置附加标题颜色。
         *
         * @param colorExtraTitle 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorExtraTitle(String colorExtraTitle) {
            this.colorExtraTitle = colorExtraTitle;
            return this;
        }

        /**
         * 设置附加标题深色颜色。
         *
         * @param colorExtraTitleDark 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorExtraTitleDark(String colorExtraTitleDark) {
            this.colorExtraTitleDark = colorExtraTitleDark;
            return this;
        }

        /**
         * 设置特殊标题颜色。
         *
         * @param colorSpecialTitle 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorSpecialTitle(String colorSpecialTitle) {
            this.colorSpecialTitle = colorSpecialTitle;
            return this;
        }

        /**
         * 设置特殊标题深色颜色。
         *
         * @param colorSpecialTitleDark 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorSpecialTitleDark(String colorSpecialTitleDark) {
            this.colorSpecialTitleDark = colorSpecialTitleDark;
            return this;
        }

        /**
         * 设置特殊标题背景颜色。
         *
         * @param colorSpecialTitleBg 颜色字符串
         * @return Builder 实例
         */
        public Builder setColorSpecialTitleBg(String colorSpecialTitleBg) {
            this.colorSpecialTitleBg = colorSpecialTitleBg;
            return this;
        }

        /**
         * 构建 BaseInfo 的 JSONObject 对象。
         *
         * @return JSONObject 对象，包含基础信息
         */
        public BaseInfo build() {
            JSONObject baseInfo = new JSONObject();
            try {
                baseInfo.put("title", title);
                baseInfo.put("colorTitle", colorTitle);
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
                baseInfo.put("type", 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new BaseInfo().setBaseInfo(baseInfo);
        }
    }
}
