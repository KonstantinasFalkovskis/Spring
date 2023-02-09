package com.klix.payments.pages.demostore.cart;

import com.klix.payments.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.payments.global.elements.GlobalElements.*;

@Component
public class CartPageMethods extends Base {

    @Step("Click checkout button")
    public void clickCheckOutButton(String text) {
        scrollToElement(getElementsByText, text);
        clickJs(getElementsByText, text);
    }

    @Step("Verify is label {label} text is displayed")
    public void verifyDemoStoreLabelIsDisplayed(String label, Integer id) {
        waitForElementToBeVisible(getElementsByTextAndArrId, label, id);
    }

    @Step("Verify is total price ${price} is displayed")
    public void verifyTotalPriceIsDisplayed(String className, String price) {
        waitForElementToBeVisible(getElementByClassNameAndText, className, price);
    }
}