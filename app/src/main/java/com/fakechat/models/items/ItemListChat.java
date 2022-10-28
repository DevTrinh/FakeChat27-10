package com.fakechat.models.items;

public class ItemListChat {
    private int drawableAvatar;
    private String chatContent;
    private String chatTitle;
    private int drawableSeen;
    private boolean isOnline;

    public ItemListChat(int drawableAvatar, String chatContent, String chatTitle, int drawableSeen, boolean isOnline) {
        this.drawableAvatar = drawableAvatar;
        this.chatContent = chatContent;
        this.chatTitle = chatTitle;
        this.drawableSeen = drawableSeen;
        this.isOnline = isOnline;
    }

    public int getDrawableAvatar() {
        return drawableAvatar;
    }

    public void setDrawableAvatar(int drawableAvatar) {
        this.drawableAvatar = drawableAvatar;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public String getChatTitle() {
        return chatTitle;
    }

    public void setChatTitle(String chatTitle) {
        this.chatTitle = chatTitle;
    }

    public int getDrawableSeen() {
        return drawableSeen;
    }

    public void setDrawableSeen(int drawableSeen) {
        this.drawableSeen = drawableSeen;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
