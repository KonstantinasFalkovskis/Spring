package com.klix.backend.models.responses;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "workspace_name",
        "workspace_sdn_traffic_limit_gb",
        "workspace_topology",
        "workspace_deleted_at",
        "workspace_id",
        "workspace_created_at"
})
public class WorkspacesResponse implements Serializable {
    @JsonProperty("workspace_name")
    private String workspaceName;
    @JsonProperty("workspace_sdn_traffic_limit_gb")
    private Integer workspaceSdnTrafficLimitGb;
    @JsonProperty("workspace_topology")
    private WorkspaceTopology workspaceTopology;
    @JsonProperty("workspace_deleted_at")
    private Object workspaceDeletedAt;
    @JsonProperty("workspace_id")
    private Integer workspaceId;
    @JsonProperty("workspace_created_at")
    private String workspaceCreatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
