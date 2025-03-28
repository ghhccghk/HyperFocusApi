package com.hyperfocus.api.info;

import java.util.Objects;

public class TextAndColorInfo {
    private String colorContent;
    private String colorContentDark;
    private String colorExtraTitle;
    private String colorExtraTitleDark;
    private String colorSpecialBg;
    private String colorSpecialTitle;
    private String colorSpecialTitleDark;
    private String colorSubContent;
    private String colorSubContentDark;
    private String colorSubTitle;
    private String colorSubTitleDark;
    private String colorTitleDark;
    private String title = "";
    private String subTitle = "";
    private String extraTitle = "";
    private String specialTitle = "";
    private String content = "";
    private String subContent = "";
    private String colorTitle = "";

    public TextAndColorInfo setColorContent(String colorContent) {
        this.colorContent = colorContent;
        return this;
    }

    public TextAndColorInfo setColorContentDark(String colorContentDark) {
        this.colorContentDark = colorContentDark;
        return this;
    }

    public TextAndColorInfo setColorExtraTitle(String colorExtraTitle) {
        this.colorExtraTitle = colorExtraTitle;
        return this;
    }

    public TextAndColorInfo setColorExtraTitleDark(String colorExtraTitleDark) {
        this.colorExtraTitleDark = colorExtraTitleDark;
        return this;
    }

    public TextAndColorInfo setColorSpecialBg(String colorSpecialBg) {
        this.colorSpecialBg = colorSpecialBg;
        return this;
    }

    public TextAndColorInfo setColorSpecialTitle(String colorSpecialTitle) {
        this.colorSpecialTitle = colorSpecialTitle;
        return this;
    }

    public TextAndColorInfo setColorSpecialTitleDark(String colorSpecialTitleDark) {
        this.colorSpecialTitleDark = colorSpecialTitleDark;
        return this;
    }

    public TextAndColorInfo setColorSubContent(String colorSubContent) {
        this.colorSubContent = colorSubContent;
        return this;
    }

    public TextAndColorInfo setColorSubContentDark(String colorSubContentDark) {
        this.colorSubContentDark = colorSubContentDark;
        return this;
    }

    public TextAndColorInfo setColorSubTitle(String colorSubTitle) {
        this.colorSubTitle = colorSubTitle;
        return this;
    }

    public TextAndColorInfo setColorSubTitleDark(String colorSubTitleDark) {
        this.colorSubTitleDark = colorSubTitleDark;
        return this;
    }

    public TextAndColorInfo setColorTitleDark(String colorTitleDark) {
        this.colorTitleDark = colorTitleDark;
        return this;
    }

    public TextAndColorInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public TextAndColorInfo setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public TextAndColorInfo setExtraTitle(String extraTitle) {
        this.extraTitle = extraTitle;
        return this;
    }

    public TextAndColorInfo setSpecialTitle(String specialTitle) {
        this.specialTitle = specialTitle;
        return this;
    }

    public TextAndColorInfo setContent(String content) {
        this.content = content;
        return this;
    }

    public TextAndColorInfo setSubContent(String subContent) {
        this.subContent = subContent;
        return this;
    }

    public TextAndColorInfo setColorTitle(String colorTitle) {
        this.colorTitle = colorTitle;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof TextAndColorInfo that)) return false;
        return Objects.equals(colorContent, that.colorContent) && Objects.equals(colorContentDark, that.colorContentDark) && Objects.equals(colorExtraTitle, that.colorExtraTitle) && Objects.equals(colorExtraTitleDark, that.colorExtraTitleDark) && Objects.equals(colorSpecialBg, that.colorSpecialBg) && Objects.equals(colorSpecialTitle, that.colorSpecialTitle) && Objects.equals(colorSpecialTitleDark, that.colorSpecialTitleDark) && Objects.equals(colorSubContent, that.colorSubContent) && Objects.equals(colorSubContentDark, that.colorSubContentDark) && Objects.equals(colorSubTitle, that.colorSubTitle) && Objects.equals(colorSubTitleDark, that.colorSubTitleDark) && Objects.equals(colorTitleDark, that.colorTitleDark) && Objects.equals(title, that.title) && Objects.equals(subTitle, that.subTitle) && Objects.equals(extraTitle, that.extraTitle) && Objects.equals(specialTitle, that.specialTitle) && Objects.equals(content, that.content) && Objects.equals(subContent, that.subContent) && Objects.equals(colorTitle, that.colorTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorContent, colorContentDark, colorExtraTitle, colorExtraTitleDark, colorSpecialBg, colorSpecialTitle, colorSpecialTitleDark, colorSubContent, colorSubContentDark, colorSubTitle, colorSubTitleDark, colorTitleDark, title, subTitle, extraTitle, specialTitle, content, subContent, colorTitle);
    }

    @Override
    public String toString() {
        return "TextAndColorInfo{" +
            "colorContent='" + colorContent + '\'' +
            ", colorContentDark='" + colorContentDark + '\'' +
            ", colorExtraTitle='" + colorExtraTitle + '\'' +
            ", colorExtraTitleDark='" + colorExtraTitleDark + '\'' +
            ", colorSpecialBg='" + colorSpecialBg + '\'' +
            ", colorSpecialTitle='" + colorSpecialTitle + '\'' +
            ", colorSpecialTitleDark='" + colorSpecialTitleDark + '\'' +
            ", colorSubContent='" + colorSubContent + '\'' +
            ", colorSubContentDark='" + colorSubContentDark + '\'' +
            ", colorSubTitle='" + colorSubTitle + '\'' +
            ", colorSubTitleDark='" + colorSubTitleDark + '\'' +
            ", colorTitleDark='" + colorTitleDark + '\'' +
            ", title='" + title + '\'' +
            ", subTitle='" + subTitle + '\'' +
            ", extraTitle='" + extraTitle + '\'' +
            ", specialTitle='" + specialTitle + '\'' +
            ", content='" + content + '\'' +
            ", subContent='" + subContent + '\'' +
            ", colorTitle='" + colorTitle + '\'' +
            '}';
    }
}
