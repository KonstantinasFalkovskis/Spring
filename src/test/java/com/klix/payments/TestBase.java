package com.klix.payments;

import com.klix.payments.utils.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = SpringConfig.class)
@Listeners(ScreenshotListener.class)
public class TestBase extends AbstractTestNGSpringContextTests {

    @Autowired
    public WebDriver webDriver;

    @Value("${url.ui-url}")
    public String baseUrl;

    @Value("${wait.implicit.seconds}")
    public Integer timeout;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        webDriver.navigate().to(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}
