package com.klix.mobile.pages.chat;

import com.klix.mobile.utils.Base;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.ruptela.driverapp.pages.chat.ChatPageElements.getMessageFromChat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@Component
public class ChatPageAssertions extends Base {

    @Step("Verify last chat message")
    public void verifyLastChatMessage(String message) {
        String clipboard = appiumDriver.getClipboardText();
        assertThat(getText(getMessageFromChat, message)).isEqualTo(clipboard);
    }
}
