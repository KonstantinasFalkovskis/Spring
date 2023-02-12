package com.klix.mobile;

import com.klix.mobile.core.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.util.List;

@SpringBootConfiguration
@ComponentScan("com.klix.mobile")
@EnableAutoConfiguration
public class SpringConfig {

    @Scope("singleton")
    @Bean(destroyMethod = "quit")
    AndroidDriver appiumDriver(List<DriverFactory> driverFactories, @Value("${appiumDriver.mode}") String mode) {
        return driverFactories.stream().filter(df -> df.name()
                .equalsIgnoreCase(mode))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unknown MobileDriver mode: " + mode))
                .newAppiumInstance();
    }

    @Bean
    WebDriverWait webDriverWait(
            WebDriver appiumDriver, @Value("${wait.explicit.seconds}") Long waitExplicitSec,
            @Value("${wait.implicit.milliseconds}") Long waitImplicitMilliSec
    ) {
        return new WebDriverWait(appiumDriver, waitExplicitSec, waitImplicitMilliSec);
    }
}
