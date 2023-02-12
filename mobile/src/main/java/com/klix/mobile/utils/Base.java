package com.klix.mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;


import static com.klix.library.mobile.constants.AppConstants.TIMEOUT;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

@Slf4j
public class Base {

    @Autowired
    protected AndroidDriver appiumDriver;

    @Autowired
    protected WebDriverWait driverWait;

    private Location location;

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     * @return - returns web element
     */

    @SafeVarargs
    protected final <T> AndroidElement findElement(String elementLocator, T... args) {
        return (AndroidElement) appiumDriver.findElement(extractBy(String.format(elementLocator, args)));
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */

    @SafeVarargs
    protected final <T> void waitForElementToBeVisible(String elementLocator, T... args) {
        log.info("Waiting for element to be visible: " + elementLocator);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(extractBy(String.format(elementLocator, args))));
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */

    @SafeVarargs
    public final <T> void waitForElementToBeInvisible(String elementLocator, T... args) {
        log.info("Waiting for element to be invisible: " + elementLocator);
        driverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(extractBy(String.format(elementLocator, args))));
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */

    @SafeVarargs
    public final <T> void waitForElementToBeClickable(String elementLocator, T... args) {
        log.info("Waiting for element to be clickable: " + elementLocator);
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
    public final <T> void enterText(String elementLocator, T keysToSend, T... args) {
        waitForElementToBeClickable(elementLocator, args);
        findElement(elementLocator, args).sendKeys(keysToSend.toString());
        log.info("Parameter " + keysToSend.toString() + " is sent to the text field");
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
        String text = findElement(elementLocator, args).getText();
        log.info(text + " is taken as a parameter");
        return text;
    }

    /**
     * @param elementLocator - String locator in Xpath or CSS format
     * @param args           - any quantity of arguments
     * @param <T>            - is referred to as any type
     */

    @SafeVarargs
    public final <T> void click(String elementLocator, T... args) {
        waitForElementToBeVisible(elementLocator, args);
        findElement(elementLocator, args).click();
        log.info("Element is clicked: " + elementLocator);
    }

    @SafeVarargs
    public final <T> void customWaits(String elementLocator, T... args) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(extractBy(String.format(elementLocator, args))));
    }

    @SafeVarargs
    public final <T> void customWaitsForElementInvisibility(String elementLocator, T... args) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(extractBy(String.format(elementLocator, args))));
    }

    public void returnToPreviousView() {
        appiumDriver.navigate().back();
    }

    public void setObjectGpsLocation(double latitude, double longitude, double altitude) {
        location = new Location(latitude, longitude, altitude);
        log.info("Object latitude is: " + location.getLatitude());
        log.info("Object longitude is: " + location.getLongitude());
        log.info("Object altitude is: " + location.getAltitude());
        appiumDriver.setLocation(location);
    }

    @PostConstruct
    private void init() {
        PageFactory.initElements(appiumDriver, this);
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
        if (locator.startsWith(".")) {
            return locator.startsWith(".View") ? By.xpath("//android.view" + locator) : By.xpath(
                    "//android.widget" + locator);
        } else if (locator.startsWith("//") || locator.startsWith("(//")) {
            return By.xpath(locator);
        } else {
            return By.cssSelector(locator);
        }
    }

    public void setInternetConnectionActivity(NetworkStatus status) {
        switch (status) {
            case WIFI_OFF:
                ConnectionState wifiStateOff = appiumDriver.setConnection(
                        new ConnectionStateBuilder().withWiFiDisabled().build());
                assertFalse(wifiStateOff.isWiFiEnabled());
                log.info("WiFi is disabled");
                break;
            case DATA_OFF:
                ConnectionState dataStateOff = appiumDriver.setConnection(
                        new ConnectionStateBuilder().withDataDisabled().build());
                assertFalse(dataStateOff.isDataEnabled());
                log.info("Mobile data is disabled");
                break;
            case WIFI_ON:
                ConnectionState wifiStateOn = appiumDriver.setConnection(
                        new ConnectionStateBuilder().withWiFiEnabled().build());
                assertTrue(wifiStateOn.isWiFiEnabled());
                log.info("WiFi is enabled");
                break;
            case DATA_ON:
                ConnectionState dataStateOn = appiumDriver.setConnection(
                        new ConnectionStateBuilder().withDataEnabled().build());
                assertTrue(dataStateOn.isDataEnabled());
                log.info("Mobile data is enabled");
                break;
            case AIRPLANE_ON:
                ConnectionState airplaneModeOn = appiumDriver.setConnection(
                        new ConnectionStateBuilder().withAirplaneModeEnabled().build());
                assertTrue(airplaneModeOn.isDataEnabled());
                log.info("Mobile data and WiFi are disabled");
                break;
            case AIRPLANE_OFF:
                ConnectionState airplaneModeOff = appiumDriver.setConnection(
                        new ConnectionStateBuilder().withAirplaneModeDisabled().build());
                assertFalse(airplaneModeOff.isDataEnabled());
                log.info("Mobile data and WiFi are enabled");
                break;
            default:
                log.info("Internet connection setup");
        }
    }

    @Getter
    public enum NetworkStatus {

        WIFI_OFF,
        WIFI_ON,
        DATA_OFF,
        DATA_ON,
        AIRPLANE_ON,
        AIRPLANE_OFF
    }
}