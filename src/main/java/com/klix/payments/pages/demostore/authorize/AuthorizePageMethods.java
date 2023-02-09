package com.klix.payments.pages.demostore.authorize;

import com.klix.payments.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.payments.global.elements.GlobalElements.getElementsByText;

@Component
public class AuthorizePageMethods extends Base {

    @Step("Click {text} button")
    public void clickContinueButton(String text) {
        clickJs(getElementsByText, text);
    }
}
