package com.klix.tests.backend.config;

import com.klix.backend.SpringConfig;
import com.klix.backend.data.DataCleanup;
import com.klix.backend.data.DataPreparation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@SpringBootTest(classes = SpringConfig.class)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

//    protected ClientResponse setupClient;

    protected DataPreparation dataPreparation;
    protected DataCleanup dataCleanup;
    protected String agentTokenSecret;
    protected Integer agentTokenId;

    @BeforeClass(alwaysRun = true)
    public void baseSetUp() {
//        agentTokenId = dataPreparation.createAgentToken().getAgentTokenId();
//        agentTokenSecret = dataPreparation.getAgentToken().getAgentTokenSecret();
//        dataCleanup.deleteAgentToken(agentTokenId);
    }

    @AfterClass(alwaysRun = true)
    public void baseTearDown() {
//        dataCleanup.deleteAgentToken(agentTokenId);
    }
}
