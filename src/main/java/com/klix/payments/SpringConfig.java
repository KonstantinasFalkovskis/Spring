package com.klix.payments;

import com.browserstack.local.Local;
import com.klix.payments.core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import java.util.HashMap;
import java.util.List;

@SpringBootConfiguration
@ComponentScan("com.klix.payments")
@EnableAutoConfiguration
public class SpringConfig {


    @Scope("singleton")
    @Bean(destroyMethod = "quit")
    WebDriver webDriver(List<DriverFactory> driverFactories, @Value("${webDriver.mode}") String mode) {
        return driverFactories.stream().filter(df -> df.name()
                        .equalsIgnoreCase(mode))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unknown WebDriver mode: " + mode))
                .newInstance();
    }

    @Scope("singleton")
    @Bean(destroyMethod = "stop")
    Local browserStackLock(Environment environment) {
        try {
            if (environment.getRequiredProperty("webDriver.mode").equals("browserStack")) {
                Local browserStackLocal = new Local();
                HashMap<String, String> bsLocalArgs = new HashMap<>();
                bsLocalArgs.put("key", environment.getRequiredProperty("webDriver.browserStack.key"));
                bsLocalArgs.put("forcelocal", environment.getRequiredProperty("webDriver.browserStack.local"));
                browserStackLocal.start(bsLocalArgs);
                return browserStackLocal;
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Bean
    WebDriverWait webDriverWait(
            WebDriver webDriver,
            @Value("${wait.explicit.seconds}") Long waitExplicitSec,
            @Value("${wait.implicit.seconds}") Long waitImplicitMilliSec
    ) {
        return new WebDriverWait(webDriver, waitExplicitSec, waitImplicitMilliSec);
    }
}
