package com.klix.backend.models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkspacesRequest {
    private String workspace_name;

    public WorkspacesRequest(String workspace_name) {
        this.workspace_name = workspace_name;
    }
}
