package com.klix.backend.models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgentTokenRequest {

    private String agent_token_name;

    public AgentTokenRequest(String agent_token_name) {
        this.agent_token_name = agent_token_name;
    }
}
