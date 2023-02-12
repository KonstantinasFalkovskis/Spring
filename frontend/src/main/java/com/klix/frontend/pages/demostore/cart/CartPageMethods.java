package com.klix.frontend.pages.demostore.cart;

import com.klix.frontend.global.elements.GlobalElements;
import com.klix.frontend.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class CartPageMethods extends Base {

    @Step("Click checkout button")
    public void clickCheckOutButton(String text) {
        scrollToElement(GlobalElements.getElementsByText, text);
        clickJs(GlobalElements.getElementsByText, text);
    }

    @Step("Verify is label {label} text is displayed")
    public void verifyDemoStoreLabelIsDisplayed(String label, Integer id) {
        waitForElementToBeVisible(GlobalElements.getElementsByTextAndArrId, label, id);
    }

    @Step("Verify is total price ${price} is displayed")
    public void verifyTotalPriceIsDisplayed(String className, String price) {
        waitForElementToBeVisible(GlobalElements.getElementByClassNameAndText, className, price);
    }
}