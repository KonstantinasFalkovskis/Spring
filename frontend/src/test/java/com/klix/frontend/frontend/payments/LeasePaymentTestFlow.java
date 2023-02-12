package com.klix.frontend.frontend.payments;

import com.klix.frontend.TestBase;
import com.klix.frontend.global.GlobalMethods;
import com.klix.frontend.pages.demostore.finansing.FinancingPageAssertions;
import com.klix.frontend.pages.demostore.finansing.FinancingPageMethods;
import com.klix.frontend.utils.Percy;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Klix payments flow")
@Feature("Positive payment flow")
public class LeasePaymentTestFlow extends TestBase {

    @Autowired
    GlobalMethods globalMethods;

    @Autowired
    FinancingPageAssertions financingPageAssertions;

    @Autowired
    FinancingPageMethods financingPageMethods;

    public Percy percy;
    //= new Percy(webDriver);

    @BeforeClass(alwaysRun = true)
    public void preTest() {
        globalMethods.addItemToCart();
//        globalMethods.openShoppingCart();
//        globalMethods.clickCheckoutButton();
//        globalMethods.clickContinueButton();
//        globalMethods.clickChoosePaymentMethodButton();
    }

//    @BeforeTest(alwaysRun = true)
//    public void slowDownDriver() throws InterruptedException {
//        Thread.sleep(2000);
//    }

    @Story("Verify calculations details of the payment method for different periods")
    @Feature("Leasing")
    @Description("Calculation details verification for 1 mont")
    @Test()
    public void paymentDetailsForOneMonthTest() throws JSONException {
        percy = new Percy(webDriver);
        System.out.println("Done");
//        globalMethods.openShoppingCart();
//        percy.snapshot("Shopping Cart");
        webDriver.navigate().to("https://shop.stage.klix.app/demo");
        percy.snapshot("Klix", "");
//        financingPageAssertions.assertCalculationDetails(MON_1, ONE_MONTH.getMonth(), CALCULATION_DETAILS.getText());
    }

    @Story("Verify calculations details of the payment method for different periods")
    @Description("Calculation details verification for 3 months")
    @Test(dependsOnMethods = "paymentDetailsForOneMonthTest")
    public void paymentDetailsForThreeMonthTest() throws JSONException {
        globalMethods.openShoppingCart();
        percy.snapshot("Shopping Cart");
//        financingPageAssertions.assertCalculationDetails(MON_3, THREE_MONTH.getMonth(), CALCULATION_DETAILS.getText());
    }
//
//    @Story("Verify calculations details of the payment method for different periods")
//    @Description("Calculation details verification for 6 months")
//    @Test(dependsOnMethods = "paymentDetailsForThreeMonthTest")
//    public void paymentDetailsForSixMonthTest() {
//        financingPageAssertions.assertCalculationDetails(MON_6, SIX_MONTH.getMonth(), CALCULATION_DETAILS.getText());
//    }
//
//    @Story("Verify calculations details of the payment method for different periods")
//    @Description("Calculation details verification for 12 months")
//    @Test(dependsOnMethods = "paymentDetailsForSixMonthTest")
//    public void paymentDetailsForTwelveMonthTest() {
//        financingPageAssertions.assertCalculationDetails(MON_12, TWELVE_MONTH.getMonth(), CALCULATION_DETAILS.getText());
//    }
//
//    @Story("Verify calculations details of the payment method for different periods")
//    @Description("Calculation details verification for 24 months")
//    @Test(dependsOnMethods = "paymentDetailsForTwelveMonthTest")
//    public void paymentDetailsForTwentyFourMonthTest() {
//        financingPageAssertions.assertCalculationDetails(MON_24, TWENTY_FOR_MONTH.getMonth(), CALCULATION_DETAILS.getText());
//    }
//
//    @Story("Login to the loan application")
//    @Description("Enter credentials to get an loan offer")
//    @Test(dependsOnMethods = "paymentDetailsForTwentyFourMonthTest")
//    public void loginToGetOfferTest() {
//        financingPageMethods.clickOnGetYourOfferButton(GET_OFFER.getText());
//        financingPageAssertions.assertStepText(STEPS_HEADER.getClassName(),LOGIN.getLabel());
//        financingPageMethods.clickMockSmartID(MOCK_SMART_ID.getText());
//        financingPageMethods.enterPersonalCode(USER_1.getPersonalCode(), PERSONAL_CODE.getElementNames());
//        financingPageMethods.enterPhone(USER_1.getPhone(), PHONE.getElementNames());
//        financingPageMethods.clickButton(CONTINUE.getText());
//    }
//
//    @Story("Fill the application data")
//    @Description("Enter the loan questionnaire to get offer")
//    @Test(dependsOnMethods = "loginToGetOfferTest")
//    public void fillQuestionnaireDataTest() {
//        financingPageAssertions.assertStepText(STEPS_HEADER.getClassName(), FILL_APPLICATION.getLabel());
//        financingPageMethods.enterEmail(USER_1.getEmail(), EMAIL.getElementId());
//        financingPageMethods.enterCity(USER_1.getCity(), CITY.getElementId());
//        financingPageMethods.enterAddress( USER_1.getAddress(), ADDRESS.getElementId());
//        financingPageMethods.enterZip( USER_1.getZip(), ZIP.getElementId());
//        financingPageMethods.selectElementFromDropDownList(MARITAL_STATUS.getElementId(), MARRIED.getStatus());
//        financingPageMethods.selectElementFromDropDownList(DEPENDENT_COUNT.getElementId(), NO_DEPENDENTS.getDependents());
//        financingPageMethods.selectElementFromDropDownList(INCOME_TYPE.getElementId(), SALARY.getIncomes());
//        financingPageMethods.enterEmployersName(EMPLOYER_NAME.getElementId(), USER_1.getName());
//        financingPageMethods.enterMonthlyIncomes(SALARY_AMOUNT.getText(), MONTHLY_INCOME.getElementId());
//        financingPageMethods.enterCurrentCreditLiabilitiesAmount(CREDIT_LIABILITIES.getText(), CREDIT_AMOUNT.getElementId());
//        financingPageMethods.selectElementFromDropDownList(PAYMENT_DATE.getElementId(), TENTH.getDates());
//        financingPageMethods.selectDataValidityConfirmation(CONFIRM_DATA_VALIDITY.getElementId());
//        financingPageMethods.selectAgreementHandlingPersonalData(CONFIRM_DATA_SHARE.getElementId());
//        financingPageMethods.clickButton(CONTINUE.getText());
//        financingPageMethods.clickButton(OK.getText());
//    }
//
//    @Story("Choose an offer")
//    @Description("Verify compiled offer data")
//    @Test(dependsOnMethods = "fillQuestionnaireDataTest")
//    public void verifyCompiledOffer() {
//        financingPageMethods.waitUntilElementInvisible(FILL_APPLICATION.getLabel());
//        financingPageAssertions.assertStepText(STEPS_HEADER.getClassName(), CHOOSE_OFFER.getLabel());
//        financingPageMethods.clickButton(GET_AGREEMENT.getText());
//    }
//
//    @Story("Review offer")
//    @Description("Verify the data of the selected loan offer")
//    @Test(dependsOnMethods = "verifyCompiledOffer")
//    public void reviewSelectedOffer() {
//        financingPageAssertions.assertStepText(STEPS_HEADER.getClassName(), REVIEW.getLabel());
//        financingPageMethods.agreeSignLoanAgreement(SIGN_LOAN_AGREEMENT.getText());
//        financingPageMethods.clickButton(SIGN_AGREEMENT_BUTTON.getText());
//    }
}