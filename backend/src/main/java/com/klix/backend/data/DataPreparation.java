package com.klix.backend.data;

import com.klix.backend.models.responses.AgentTokenResponse;
import com.klix.backend.utils.services.AgentsUtils;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public class DataPreparation {

    @Autowired
    public AgentsUtils agentsUtils;

    public AgentTokenResponse createAgentToken() {
        return agentsUtils.createAgentToken();
    }

    public AgentTokenResponse getAgentToken() {
        return agentsUtils.getAgentToken();
    }
}
