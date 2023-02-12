package com.klix.backend.utils.services;

import com.klix.backend.models.requests.AgentTokenRequest;
import com.klix.backend.models.responses.AgentTokenResponse;
import com.klix.backend.utils.exceptions.AgentTokensExceptions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static com.klix.backend.config.Base.requestBuilderForTT2WithAuthHeader;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Value;

import static com.klix.backend.data.TokensData.TOKEN_NAME;

public class AgentsUtils {
    private AgentTokenRequest agentTokenRequest;

    @Value("${api.base}")
    public String baseUrl;

    @Value("${api.tokens.agent}")
    public String path;

    public AgentTokenResponse createAgentToken() {
        try {
            return requestBuilderForTT2WithAuthHeader(baseUrl, path)
                    .statusCode(HttpStatus.SC_OK)
                    .body(agentTokenRequest = new AgentTokenRequest(TOKEN_NAME))
                    .postReturnItem("data", AgentTokenResponse.class);
        } catch (Exception | AssertionError exception) {
            throw new AgentTokensExceptions.CreateAgentTokenException("Unable to create agent token", exception);
        }
    }

        public AgentTokenResponse getAgentToken() {
            try {
                return requestBuilderForTT2WithAuthHeader(baseUrl, path)
                        .statusCode(HttpStatus.SC_OK)
                        .getReturnItem("data",AgentTokenResponse.class);
            } catch (Exception | AssertionError exception) {
                throw new AgentTokensExceptions.GetAgentTokenException("Unable to get agent token", exception);
            }
    }

    public void deleteAgentToken(Integer id) {
        try {
           requestBuilderForTT2WithAuthHeader(id, baseUrl, path)
                    .statusCode(HttpStatus.SC_NO_CONTENT)
                    .delete();
        } catch (Exception | AssertionError exception) {
            throw new AgentTokensExceptions.DeleteAgentTokenException("Unable to delete agent token", exception);
        }
    }
}
