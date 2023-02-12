package com.klix.mobile.pages.chat;

import com.klix.mobile.utils.Base;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.klix.mobile.pages.chat.ChatPageElements.getSendButton;
import static com.klix.mobile.pages.chat.ChatPageElements.getTextField;

@Slf4j
@Component
public class ChatPageMethods extends Base {


    @Step("Enter message '{message}' to clipboard")
    public void enterMessageToClipboard(String message) {
        appiumDriver.setClipboardText(message);
        log.info("Message text is saved to clipboard");
    }

    @Step("Enter message from clipboard")
    public void enterMessageFromClipboard() {
        String message = appiumDriver.getClipboardText();
        enterText(getTextField, message);
        log.info(message + " is taken from clipboard");
    }

    @Step("Enter message to chat")
    public void enterMessageToChat(String message) {
        enterText(getTextField, message);
        log.info(message + " is entered to text field");
    }

    @Step("Click send button")
    public void clickSendButton() {
        click(getSendButton);
        log.info("Click send button");
    }

    @Step("Click back button")
    public void clickBackButton() {
        returnToPreviousView();
        log.info("Click back button");
    }
}
