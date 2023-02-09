package com.klix.payments.global;

import com.klix.payments.pages.demostore.authorize.AuthorizePageMethods;
import com.klix.payments.pages.demostore.cart.CartPageMethods;
import com.klix.payments.pages.demostore.checkout.CheckoutPageMethods;
import com.klix.payments.pages.demostore.main.MainPageMethods;
import com.klix.payments.pages.demostore.payment_methods.PaymentMethodsPageMethods;
import com.klix.payments.utils.Base;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.klix.payments.global.constants.GlobalConstants.ArrayElements.*;
import static com.klix.payments.global.constants.GlobalConstants.ClassNames.*;
import static com.klix.payments.global.constants.GlobalConstants.ElementNames.NAME_SURNAME;
import static com.klix.payments.global.constants.GlobalConstants.GlobalLabels.STORE;
import static com.klix.payments.global.constants.GlobalConstants.Prices.EU_100;
import static com.klix.payments.global.constants.GlobalConstants.Texts.*;
import static com.klix.payments.global.constants.GlobalConstants.Users.USER_1;

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
        mainPageMethods.logoElementIsDisplayed(LOGO.getClassName());
        mainPageMethods.addItemToCart(ADD_ITEM_TO_CART.getClassName(), FOURTH.getValue());
    }

    @Step("Open shopping cart")
    public void openShoppingCart() {
        mainPageMethods.clickShoppingCart(CART.getClassName());
    }

    @Step("Verify total price and start checkout")
    public void clickCheckoutButton() {
        cartPageMethods.verifyDemoStoreLabelIsDisplayed(STORE.getLabel(), FIRST.getValue());
        cartPageMethods.verifyTotalPriceIsDisplayed(TOTAL_COST.getClassName(), EU_100.getPrice());
        cartPageMethods.clickCheckOutButton(CHECKOUT.getText());
    }

    @Step("Select type of the authorization")
    public void clickContinueButton() {
        authorizePageMethods.clickContinueButton(CONTINUE.getText());
    }

    @Step("Choose payment method")
    public void clickChoosePaymentMethodButton() {
        checkoutPageMethods.enterUserName(USER_1.getName(), NAME_SURNAME.getElementNames());
        checkoutPageMethods.clickChoosePaymentMethodButton(CHOOSE_PAYMENT_METHOD.getText());
        paymentMethodsPageMethods.clickKlixPaylaterLVMethod(KLIX_PAY_LATER_METHOD.getClassName(), THIRD.getValue());
    }
}
