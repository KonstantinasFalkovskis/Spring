package com.klix.payments.core;

import org.openqa.selenium.WebDriver;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class WebDriverFactory implements DriverFactory {
    private final DriverType driverType;

    public WebDriverFactory(Environment env) {
        driverType = DriverType.valueOf(env.getRequiredProperty("webDriver.browser").toUpperCase());
    }

    @Override
    public WebDriver newInstance() {
        return driverType.getWebDriverObject(driverType.getDesiredCapabilities());
    }

    @Override
    public String name() {
        return "selenium";
    }
}
