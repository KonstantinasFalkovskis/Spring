package com.klix.mobile.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterSuite;

/**
 * Samsung Tab 10 (2019) Android 9.0 adb device ID: R9WN714Q5HJ
 * Android emulator adb device ID: emulator-5554
 */
@Component
public class LocalBrowserStackMobileDriverFactory implements DriverFactory {

    public DesiredCapabilities capabilities;
    public URL url;

    public LocalBrowserStackMobileDriverFactory() throws Exception {
        String appPath = "C:" + File.separator + "OPT" + File.separator + "apps" + File.separator + "test.apk";
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        capabilities.setCapability(MobileCapabilityType.VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("appPackage", "apk.applicationName");
        capabilities.setCapability("appWaitActivity", "LoginActivity");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("gpsEnabled", "true");
        capabilities.setCapability("noReset","false");
        capabilities.setCapability("newCommandTimeout", 780000);
        capabilities.setCapability("adbExecTimeout", 20000);
        capabilities.setCapability("remoteAppsCacheLimit", 0);

        url = new URL("http://127.0.0.1:4723/wd/hub");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownLocal() {
        newAppiumInstance().quit();
    }

    @Override
    public AndroidDriver newAppiumInstance() {
        AndroidDriver appiumDriver = new AndroidDriver(url, capabilities);
        appiumDriver.setFileDetector(new LocalFileDetector());
        return appiumDriver;
    }

    @Override
    public String name() {
        return "emulator";
    }
}