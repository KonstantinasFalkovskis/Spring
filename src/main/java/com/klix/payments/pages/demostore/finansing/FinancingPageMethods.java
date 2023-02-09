package com.klix.payments.pages.demostore.finansing;

import com.klix.payments.utils.Base;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;
import static com.klix.payments.global.elements.GlobalElements.*;


@Component
public class FinancingPageMethods extends Base {

    @Step("Extend calculation details")
    public void extendCalculationDetails(String text) {
        click(getElementsByText, text);
    }

    @Step("Click on loan agreement period")
    public void clickOnLoanAgreementPeriod(String month) {
        click(getElementsByText, month);
    }

    @Step("Click on Get your offer button")
    public void clickOnGetYourOfferButton(String text) {
        click(getElementsByText, text);
    }

    @Step("Select Mock Smart-ID for testing purposes")
    public void clickMockSmartID(String tagName) {
        click(getElementsByText, tagName);
    }

    @Step("Enter personal code")
    public void enterPersonalCode(String personalCode, String className) {
        enterText(getElementByTagName, personalCode, className);
    }

    @Step("Enter phone")
    public void enterPhone(String phone, String className) {
        enterText(getElementByTagName, phone, className);
    }

    @Step("Enter email")
    public void enterEmail(String email, String elementId) {
        enterText(getElementByElementId, email, elementId);
    }

    @Step("Enter city")
    public void enterCity(String city, String elementId) {
        enterText(getElementByElementId, city, elementId);
    }

    @Step("Enter address")
    public void enterAddress(String address, String elementId) {
        enterText(getElementByElementId, address, elementId);
    }

    @Step("Enter zip code")
    public void enterZip(String zip, String elementId) {
        enterText(getElementByElementId, zip, elementId);
    }

    @Step("Enter employers name")
    public void enterEmployersName(String elementId, String name) {
        enterText(getElementByElementId, name, elementId);
    }

    @Step("Enter monthly incomes")
    public void enterMonthlyIncomes(String incomes, String elementId) {
        enterText(getElementByElementId, incomes, elementId);
    }

    @Step("Enter current credit liabilities amount")
    public void enterCurrentCreditLiabilitiesAmount(String creditAmount, String elementId) {
        enterText(getElementByElementId, creditAmount, elementId);
    }

    @Step("Select payment date")
    public void selectPoliticalExposing(String exposing) {
        click(getElementsByText, exposing);
    }

    @Step("Select confirmation for provided data validity")
    public void selectDataValidityConfirmation(String elementId) {
        click(getElementByElementId, elementId);
    }

    @Step("Select confirmation to handling application data")
    public void selectAgreementHandlingPersonalData(String elementId) {
        click(getElementByElementId, elementId);
    }

    @Step("Select confirmation to receive notifications")
    public void selectAgreementReceiveNotifications(String elementId) {
        click(getElementByElementId, elementId);
    }

    @Step("Click {text} Button")
    public void clickButton(String text) {
        scrollToElement(getElementsByText, text);
        clickJs(getElementsByText, text);
    }

    @Step("Select element {text} from drop down list ")
    public void selectElementFromDropDownList(String elementId, String text) {
        selectElementFromDopDownMenu(elementId).selectByVisibleText(text);
    }

    @Step("Wait until text will be unavailable while best loan offer is compiling")
    public void waitUntilElementInvisible(String text) {
        waitForElementToBeInvisible(getElementsByText, text);
    }

    @Step("Agree to sign the loan agreement")
    public void agreeSignLoanAgreement(String text) {
        click(getElementsByText, text);
    }

}
