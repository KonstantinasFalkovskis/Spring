package com.klix.payments.pages.demostore.checkout;

import com.klix.payments.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.payments.global.elements.GlobalElements.getElementByTagName;
import static com.klix.payments.global.elements.GlobalElements.getElementsByText;

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
