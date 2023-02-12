package com.klix.mobile;

import com.klix.mobile.pages.login.AppLoginPageMethods;
import com.klix.mobile.utils.Base;
import io.restassured.http.Header;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Slf4j
@SpringBootTest(classes = SpringConfig.class)
public class TestBase extends AbstractTestNGSpringContextTests {

    @Autowired
    protected AppLoginPageMethods appLoginPageMethods;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
    }

    @AfterClass(alwaysRun = true)
    public void closeApp() {
    }
}