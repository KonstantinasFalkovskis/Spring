package com.klix.frontend.pages.demostore.finansing;

import com.klix.frontend.global.constants.GlobalConstants;
import com.klix.frontend.utils.Base;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import static com.klix.frontend.global.elements.GlobalElements.getElementByClassNameAndText;
import static com.klix.frontend.global.elements.GlobalElements.getElementsByText;

@Component
public class FinancingPageAssertions extends Base {

    @Autowired
    FinancingPageMethods financingPageMethods;

    @Step("Verify calculation details of the payment")
    public void assertCalculationDetails(GlobalConstants.OfferExamples offers, String month, String link) {
        financingPageMethods.clickOnLoanAgreementPeriod(month);
        financingPageMethods.extendCalculationDetails(link);
        Assert.assertTrue(getText(getElementsByText, offers.getLoanAmount()).contains(offers.getLoanAmount()));
        Assert.assertTrue(getText(getElementsByText, offers.getTotalAmount()).contains(offers.getTotalAmount()));
        Assert.assertTrue(getText(getElementsByText, offers.getMonthlyAmount()).contains(offers.getMonthlyAmount()));
    }

    @Step("Verify the step text of the loan application")
    public void assertStepText(String className, String label) {
        Assert.assertTrue(getText(getElementByClassNameAndText, className, label).equals(label));
    }
}
