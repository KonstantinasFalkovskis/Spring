package com.klix.frontend.pages.demostore.checkout;

import com.klix.frontend.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.frontend.global.elements.GlobalElements.getElementByTagName;
import static com.klix.frontend.global.elements.GlobalElements.getElementsByText;

@Component
public class CheckoutPageMethods extends Base {
    @Step("Click {text} button")
    public void clickChoosePaymentMethodButton(String text) {
        click(getElementsByText, text);
    }

    @Step("Update user name")
    public void enterUserName(String text, String taName) {
        click(getElementByTagName, taName);
        enterText(getElementByTagName, text, taName);
    }
}
