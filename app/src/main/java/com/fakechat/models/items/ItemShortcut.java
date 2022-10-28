package com.fakechat.models.items;

public class ItemShortcut {
    private int drawableShortcut;
    private boolean isFirst;
    private boolean isOnline;
    private String nameShortcut;

    public ItemShortcut(int drawableShortcut, boolean isFirst, boolean isOnline, String nameShortcut) {
        this.drawableShortcut = drawableShortcut;
        this.isFirst = isFirst;
        this.isOnline = isOnline;
        this.nameShortcut = nameShortcut;
    }

    public String getNameShortcut() {
        return nameShortcut;
    }

    public void setNameShortcut(String nameShortcut) {
        this.nameShortcut = nameShortcut;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public int getDrawableShortcut() {
        return drawableShortcut;
    }

    public void setDrawableShortcut(int drawableShortcut) {
        this.drawableShortcut = drawableShortcut;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
