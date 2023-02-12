package com.klix.mobile.core;

import com.browserstack.local.Local;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterSuite;

import java.net.URL;
import java.util.HashMap;

@Component
public class BrowserStackMobileDriverFactory implements DriverFactory {

    public DesiredCapabilities capabilities;
    public URL url;
    public Local browserStackLocal;

    public BrowserStackMobileDriverFactory(Environment environment) throws Exception {

        String USERNAME = environment.getRequiredProperty("webDriver.browserStack.username");
        String AUTOMATE_KEY = environment.getRequiredProperty("webDriver.browserStack.key");
        String DOMAIN = environment.getRequiredProperty("webDriver.browserStack.domain");
        String LOCAL = environment.getRequiredProperty("webDriver.browserStack.local");
        String APPLICATION = environment.getRequiredProperty("appiumDriver.app");
        String DEVICE = environment.getRequiredProperty("appiumDriver.device");
        String VERSION = environment.getRequiredProperty("appiumDriver.mobOsVersion");
        String PROJECT = environment.getRequiredProperty("appiumDriver.project");
        String BUILD = environment.getRequiredProperty("appiumDriver.build");
        String NAME = environment.getRequiredProperty("appiumDriver.name");

        browserStackLocal = new Local();
        HashMap<String, String> bsLocalArgs = new HashMap<>();
        bsLocalArgs.put("key", AUTOMATE_KEY);
        bsLocalArgs.put("forcelocal", LOCAL);
        browserStackLocal.start(bsLocalArgs);

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", USERNAME);
        capabilities.setCapability("browserstack.key", AUTOMATE_KEY);
        capabilities.setCapability("app", APPLICATION);
        capabilities.setCapability("device", DEVICE);
        capabilities.setCapability("os_version", VERSION);
        capabilities.setCapability("browserstack.local", LOCAL);
        capabilities.setCapability("project", PROJECT);
        capabilities.setCapability("build", BUILD);
        capabilities.setCapability("name", NAME);
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("noReset","false");
        capabilities.setCapability("gpsEnabled", "true");
        capabilities.setCapability("adbExecTimeout", 20000);
        capabilities.setCapability("remoteAppsCacheLimit", 0);
        capabilities.setCapability("newCommandTimeout", 180000);

        url = new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@" + DOMAIN);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownLocal() throws Exception {
        browserStackLocal.stop();
    }

    @Override
    public AndroidDriver newAppiumInstance() {
        AndroidDriver appiumDriver = new AndroidDriver(url, capabilities);
        appiumDriver.setFileDetector(new LocalFileDetector());
        return appiumDriver;
    }

    @Override
    public String name() {
        return "browserStack";
    }
}