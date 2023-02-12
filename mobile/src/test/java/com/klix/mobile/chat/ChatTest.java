package com.klix.mobile.chat;

import com.klix.mobile.TestBase;
//import com.klix.mobile.pages.chat.ChatPageAssertions;
//import com.klix.mobile.pages.chat.ChatPageMethods;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
//import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
//
//import static com.klix.library.mobile.constants.AppConstants.MESSAGE_TEXT;

@Epic("OnTrack-tests")
@Feature("Driverapp")
@Story("Test suite to verify chat activities")
public class ChatTest extends TestBase {

//    @Autowired
//    private ChatPageAssertions chatPageAssertions;
//
//    @Autowired
//    private ChatPageMethods chatPageMethods;

    @Test(groups = {"regression", "chat"})
    @Severity(SeverityLevel.NORMAL)
    @Description(
            "As a driver I want to copy text message from chat so that I do not need to re-write the text in other " +
                    "apps if needed.")
    @Issue("GUI-24318")
    public void copyTextFromChatTest() {
//        chatPageMethods.enterMessageToChat(MESSAGE_TEXT);
//        chatPageMethods.clickSendButton();
//        chatPageMethods.enterMessageToClipboard(MESSAGE_TEXT);
//        chatPageMethods.enterMessageFromClipboard();
//        chatPageMethods.clickSendButton();
//        chatPageAssertions.verifyLastChatMessage(MESSAGE_TEXT);
//        chatPageMethods.clickBackButton();
    }
}