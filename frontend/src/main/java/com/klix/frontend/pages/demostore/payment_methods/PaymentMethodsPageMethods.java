package com.klix.frontend.pages.demostore.payment_methods;

import com.klix.frontend.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.klix.frontend.global.elements.GlobalElements.getElementsByClassNameAndArrId;

@Component
public class PaymentMethodsPageMethods extends Base {

    @Step("Click Klix Pay Later method (LV)")
    public void clickKlixPaylaterLVMethod(String className, Integer id) {
        click(getElementsByClassNameAndArrId, className, id);
    }
}
