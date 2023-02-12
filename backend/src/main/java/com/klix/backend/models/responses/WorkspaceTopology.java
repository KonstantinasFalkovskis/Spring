package com.klix.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Getter
//@Setter
//@Builder(toBuilder = true)
//@ToString
//@JsonInclude(JsonInclude.Include.NON_NULL)

//@Builder
//@Data

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "topology_id",
        "topology_name",
        "topology_default",
        "topology_created_at",
        "topology_updated_at"
})
public class WorkspaceTopology {
    @JsonProperty("topology_id")
    private Integer topologyId;
    @JsonProperty("topology_name")
    private String topologyName;
    @JsonProperty("topology_default")
    private Boolean topologyDefault;
    @JsonProperty("topology_created_at")
    private String topologyCreatedAt;
    @JsonProperty("topology_updated_at")
    private String topologyUpdatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
