package com.klix.frontend.pages.demostore.main;

import com.klix.frontend.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.frontend.global.elements.GlobalElements.getElementByClassNameAndArrId;
import static com.klix.frontend.global.elements.GlobalElements.getElementByClassname;

@Component
public class MainPageMethods extends Base {

    @Step("Verify logo element is displayed")
    public void logoElementIsDisplayed(String className) {
        waitForElementToBeVisible(getElementByClassname, className);
    }

    @Step("Add item into shopping cart")
    public void addItemToCart(String className, Integer id) {
        clickJs(getElementByClassNameAndArrId, className, id);
    }

    @Step("Click shopping cart icon")
    public void clickShoppingCart(String className) {
        clickJs(getElementByClassname, className);
    }
}
