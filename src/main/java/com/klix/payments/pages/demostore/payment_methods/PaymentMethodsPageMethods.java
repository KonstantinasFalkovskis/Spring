package com.klix.payments.pages.demostore.payment_methods;

import com.klix.payments.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.payments.global.elements.GlobalElements.getElementsByClassNameAndArrId;

@Component
public class PaymentMethodsPageMethods extends Base {

    @Step("Click Klix Pay Later method (LV)")
    public void clickKlixPaylaterLVMethod(String className, Integer id) {
        click(getElementsByClassNameAndArrId, className, id);
    }
}
