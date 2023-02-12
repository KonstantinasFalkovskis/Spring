package com.klix.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "agent_token_created_at",
        "agent_token_id",
        "agent_token_name",
        "agent_token_secret",
        "agent_token_updated_at",
        "workspace_id",
        "agent_token_allowed_tag_names",
        "agent_token_description",
        "agent_token_valid_until"
})
public class AgentTokenResponse {
    @JsonProperty("agent_token_created_at")
    private String agentTokenCreatedAt;
    @JsonProperty("agent_token_id")
    private Integer agentTokenId;
    @JsonProperty("agent_token_name")
    private String agentTokenName;
    @JsonProperty("agent_token_secret")
    private String agentTokenSecret;
    @JsonProperty("agent_token_updated_at")
    private String agentTokenUpdatedAt;
    @JsonProperty("workspace_id")
    private Integer workspaceId;
    @JsonProperty("agent_token_allowed_tag_names")
    private List<Object> agentTokenAllowedTagNames = null;
    @JsonProperty("agent_token_description")
    private Object agentTokenDescription;
    @JsonProperty("agent_token_valid_until")
    private Object agentTokenValidUntil;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
