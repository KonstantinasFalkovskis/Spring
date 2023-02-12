package com.klix.mobile.pages.chat;

public class ChatPageElements {

    public static final String getMessageFromChat = "(//android.widget.TextView[@resource-id='apk" +
            ".drivers:id/message_text'][@text='%s'])[last()]";
    public static final String getSendButton = ".ImageView[@resource-id='apk.drivers:id/send_button']";
    public static final String getTextField = ".EditText[@resource-id='apk.drivers:id/message_field']";
}
