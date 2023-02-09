package com.klix.payments.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;

public class Base {
    @Autowired
    public WebDriver driver;

    @Value("${url.ui-url}")
    public String baseURL;

    @Autowired
    private WebDriverWait driverWait;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Extract By (CSS or Xpath) depending on element locator format
     *
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     * @return - By CSS or Xpath depending on element locator format
     */
    @SafeVarargs
    private <T> By extractBy(String elementLocator, T... args) {
        String locator = String.format(elementLocator, args);
        if (locator.startsWith("//") || locator.startsWith("(//")) {
            return By.xpath(locator);
        } else {
            return By.cssSelector(locator);
        }
    }

    public Actions action() {
        return new Actions(driver);
    }

     /**
     * @param baseURL - start of URL from application.yml file
     * @param endURL  - end of URL of needed website
     */
    public void navigateToURL(String baseURL, String endURL) {
        driver.navigate().to(baseURL + endURL);
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     * @return - returns web element
     */
    @SafeVarargs
    public final <T> WebElement findElement(String elementLocator, T... args) {
        return driver.findElement(extractBy(String.format(elementLocator, args)));
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     * @return - returns list of web elements
     */
    @SafeVarargs
    public final <T> List<WebElement> findElements(String elementLocator, T... args) {
        return driver.findElements(extractBy(String.format(elementLocator, args)));
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */
    @SafeVarargs
    public final <T> void waitForElementToBeVisible(String elementLocator, T... args) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(extractBy(String.format(elementLocator, args))));
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */
    @SafeVarargs
    public final <T> void waitForElementToBeInvisible(String elementLocator, T... args) {
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(extractBy(String.format(elementLocator, args))));
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */
    @SafeVarargs
    public final <T> void waitForElementToBeClickable(String elementLocator, T... args) {
        driverWait.until(ExpectedConditions.elementToBeClickable(extractBy(String.format(elementLocator, args))));
    }

    /**
     * Enters text to input field
     *
     * @param elementLocator - String locator in Xpath or CSS format
     * @param keysToSend     - text to enter in site
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */
    @SafeVarargs
    public final <T> void enterText(String elementLocator, String keysToSend, T... args) {
        waitForElementToBeClickable(elementLocator, args);
        deleteText(elementLocator, args);
        findElement(elementLocator, args).sendKeys(keysToSend);
    }

     /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     * @return - returns text from element
     */
    @SafeVarargs
    public final <T> String getText(String elementLocator, T... args) {
        waitForElementToBeVisible(elementLocator, args);
        return findElement(elementLocator, args).getText();
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param attributeName  - name of attribute value is needed
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     * @return - returns value of needed attribute
     */
    @SafeVarargs
    public final <T> String getAttributeValue(String elementLocator, String attributeName, T... args) {
        waitForElementToBeVisible(elementLocator, args);
        return findElement(elementLocator, args).getAttribute(attributeName);
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     * @return - returns value of text content attribute
     */
    @SafeVarargs
    public final <T> String getTextContentValue(String elementLocator, T... args) {
        waitForElementToBeVisible(elementLocator, args);
        return findElement(elementLocator, args).getAttribute("textContent");
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */
    @SafeVarargs
    public final <T> void click(String elementLocator, T... args) {
        waitForElementToBeClickable(elementLocator, args);
        action().click(findElement(elementLocator, args)).perform();
    }

    /**
     *
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */
    @SafeVarargs
    public final <T> void clickJs(String elementLocator, T... args) {
        waitForElementToBeClickable(elementLocator, args);
        WebElement element = findElement(elementLocator, args);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */
    @SafeVarargs
    public final <T> void deleteText(String elementLocator, T... args) {
        waitForElementToBeClickable(elementLocator, args);
        findElement(elementLocator, args).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        findElement(elementLocator, args).sendKeys(Keys.DELETE);
    }

    /**
     * Scroll to the element
     *
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     * @return - return true or false
     */
    public final <T> void scrollToElement(String elementLocator, T... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(elementLocator, args));
    }

    @SafeVarargs
    public final <T> Select selectElementFromDopDownMenu(String elementLocator, T... args) {
        waitForElementToBeClickable(elementLocator, args);
        Select dropdownList = new Select(findElement(elementLocator, args));
        return dropdownList;
    }
}