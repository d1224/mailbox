package com.hubu.mailbox.bean;

public class MailBean {

    //发送人ID
    private int senderID ;
    //接受者ID
    private int receiverID ;
    //好友头像
    private String imgUrl ;
    //好友名称
    private String chatName ;
    //最新的聊天内容
    private String chatContent ;
    //发送日期
    private String chatDate ;
    //消息提醒
    private String tips ;

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public String getChatDate() {
        return chatDate;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    @Override
    public String toString() {
        return getChatName() + getChatContent();
    }
}
