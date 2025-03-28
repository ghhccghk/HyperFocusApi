package com.hyperfocus.api.info;

import java.util.Objects;

public final class ActionInfo {
    private String action;
    private String actionBgColor;
    private String actionBgColorDark;
    private String actionIcon;
    private String actionIconDark;
    private String actionIntent;
    private Integer actionIntentType;
    private String actionTitle;
    private String actionTitleColor;
    private String actionTitleColorDark;

    public ActionInfo setAction(String action) {
        this.action = action;
        return this;
    }

    public ActionInfo setActionBgColor(String actionBgColor) {
        this.actionBgColor = actionBgColor;
        return this;
    }

    public ActionInfo setActionBgColorDark(String actionBgColorDark) {
        this.actionBgColorDark = actionBgColorDark;
        return this;
    }

    public ActionInfo setActionIcon(String actionIcon) {
        this.actionIcon = actionIcon;
        return this;
    }

    public ActionInfo setActionIconDark(String actionIconDark) {
        this.actionIconDark = actionIconDark;
        return this;
    }

    public ActionInfo setActionIntent(String actionIntent) {
        this.actionIntent = actionIntent;
        return this;
    }

    public ActionInfo setActionIntentType(Integer actionIntentType) {
        this.actionIntentType = actionIntentType;
        return this;
    }

    public ActionInfo setActionTitle(String actionTitle) {
        this.actionTitle = actionTitle;
        return this;
    }

    public ActionInfo setActionTitleColor(String actionTitleColor) {
        this.actionTitleColor = actionTitleColor;
        return this;
    }

    public ActionInfo setActionTitleColorDark(String actionTitleColorDark) {
        this.actionTitleColorDark = actionTitleColorDark;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ActionInfo that)) return false;
        return Objects.equals(action, that.action) && Objects.equals(actionBgColor, that.actionBgColor) && Objects.equals(actionBgColorDark, that.actionBgColorDark) && Objects.equals(actionIcon, that.actionIcon) && Objects.equals(actionIconDark, that.actionIconDark) && Objects.equals(actionIntent, that.actionIntent) && Objects.equals(actionIntentType, that.actionIntentType) && Objects.equals(actionTitle, that.actionTitle) && Objects.equals(actionTitleColor, that.actionTitleColor) && Objects.equals(actionTitleColorDark, that.actionTitleColorDark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, actionBgColor, actionBgColorDark, actionIcon, actionIconDark, actionIntent, actionIntentType, actionTitle, actionTitleColor, actionTitleColorDark);
    }

    @Override
    public String toString() {
        return "ActionInfo{" +
            "action='" + action + '\'' +
            ", actionBgColor='" + actionBgColor + '\'' +
            ", actionBgColorDark='" + actionBgColorDark + '\'' +
            ", actionIcon='" + actionIcon + '\'' +
            ", actionIconDark='" + actionIconDark + '\'' +
            ", actionIntent='" + actionIntent + '\'' +
            ", actionIntentType=" + actionIntentType +
            ", actionTitle='" + actionTitle + '\'' +
            ", actionTitleColor='" + actionTitleColor + '\'' +
            ", actionTitleColorDark='" + actionTitleColorDark + '\'' +
            '}';
    }
}
