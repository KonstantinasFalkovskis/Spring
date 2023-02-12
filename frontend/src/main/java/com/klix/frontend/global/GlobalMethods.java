package com.klix.frontend.global;

import com.klix.frontend.global.constants.GlobalConstants;
import com.klix.frontend.pages.demostore.authorize.AuthorizePageMethods;
import com.klix.frontend.pages.demostore.cart.CartPageMethods;
import com.klix.frontend.pages.demostore.checkout.CheckoutPageMethods;
import com.klix.frontend.pages.demostore.main.MainPageMethods;
import com.klix.frontend.pages.demostore.payment_methods.PaymentMethodsPageMethods;
import com.klix.frontend.utils.Base;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GlobalMethods extends Base {

    @Autowired
    MainPageMethods mainPageMethods;

    @Autowired
    CartPageMethods cartPageMethods;

    @Autowired
    AuthorizePageMethods authorizePageMethods;

    @Autowired
    CheckoutPageMethods checkoutPageMethods;

    @Autowired
    PaymentMethodsPageMethods paymentMethodsPageMethods;

    @Step("Add 100 Eu item into the shopping cart")
    public void addItemToCart() {
        mainPageMethods.logoElementIsDisplayed(GlobalConstants.ClassNames.LOGO.getClassName());
        mainPageMethods.addItemToCart(GlobalConstants.ClassNames.ADD_ITEM_TO_CART.getClassName(), GlobalConstants.ArrayElements.FOURTH.getValue());
    }

    @Step("Open shopping cart")
    public void openShoppingCart() {
        mainPageMethods.clickShoppingCart(GlobalConstants.ClassNames.CART.getClassName());
    }

    @Step("Verify total price and start checkout")
    public void clickCheckoutButton() {
        cartPageMethods.verifyDemoStoreLabelIsDisplayed(GlobalConstants.GlobalLabels.STORE.getLabel(), GlobalConstants.ArrayElements.FIRST.getValue());
        cartPageMethods.verifyTotalPriceIsDisplayed(GlobalConstants.ClassNames.TOTAL_COST.getClassName(), GlobalConstants.Prices.EU_100.getPrice());
        cartPageMethods.clickCheckOutButton(GlobalConstants.Texts.CHECKOUT.getText());
    }

    @Step("Select type of the authorization")
    public void clickContinueButton() {
        authorizePageMethods.clickContinueButton(GlobalConstants.Texts.CONTINUE.getText());
    }

    @Step("Choose payment method")
    public void clickChoosePaymentMethodButton() {
        checkoutPageMethods.enterUserName(GlobalConstants.Users.USER_1.getName(), GlobalConstants.ElementNames.NAME_SURNAME.getElementNames());
        checkoutPageMethods.clickChoosePaymentMethodButton(GlobalConstants.Texts.CHOOSE_PAYMENT_METHOD.getText());
        paymentMethodsPageMethods.clickKlixPaylaterLVMethod(GlobalConstants.ClassNames.KLIX_PAY_LATER_METHOD.getClassName(), GlobalConstants.ArrayElements.THIRD.getValue());
    }
}
