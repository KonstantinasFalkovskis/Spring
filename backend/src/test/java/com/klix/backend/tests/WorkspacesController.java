package com.klix.backend.tests;

import com.klix.backend.config.BaseTest;
import com.klix.backend.models.requests.WorkspacesRequest;
import com.klix.backend.models.responses.Errors;
import com.klix.backend.models.responses.WorkspacesResponse;
import com.klix.backend.utils.exceptions.WorkspacesExceptions;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static com.klix.backend.config.Base.requestBuilderForTT2WithAuthHeader;
import static com.klix.backend.data.WorkspacesData.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Test
public class WorkspacesController extends BaseTest {

    @Value("${api.workspaces}")
    private String path;
    private Integer workspaceId;
    private String workspaceName;

    @Value("${credentials.token}")
    private String token;
    private WorkspacesRequest workspacesRequest;
    private WorkspacesResponse workspacesResponse;

    @Test
    public void createWorkspaceWithLongName() {
        try {
        Errors[] response = requestBuilderForTT2WithAuthHeader(token, path)
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(workspacesRequest = new WorkspacesRequest(LONG_NAME))
                    .postReturnItem("errors",Errors[].class);
        } catch (Exception | AssertionError exception) {
            throw new WorkspacesExceptions.CreateWorkspaceException("Unable to create workspace", exception);
        }
    }

    @Test
    public void createWorkspaceWithEmptyName() {
        try {
            Errors[] response = requestBuilderForTT2WithAuthHeader(token, path)
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(workspacesRequest = new WorkspacesRequest(EMPTY_NAME))
                    .postReturnItem("errors",Errors[].class);
        } catch (Exception | AssertionError exception) {
            throw new WorkspacesExceptions.CreateWorkspaceException("Unable to create workspace", exception);
        }
    }

    @Test
    public void createWorkspace() {
        try {
            WorkspacesResponse response = requestBuilderForTT2WithAuthHeader(token, path)
                    .statusCode(HttpStatus.SC_OK)
                    .body(workspacesRequest = new WorkspacesRequest(NAME))
                    .postReturnItem("data",WorkspacesResponse.class);
            assertThat(response).isNotNull();
            workspaceId = response.getWorkspaceId();
            workspaceName = response.getWorkspaceName();
            assertThat(response.getWorkspaceId()).isNotNull();
            assertThat(response.getWorkspaceName()).isEqualTo(NAME);
            assertThat(response.getWorkspaceTopology().getTopologyName()).isEqualTo("Sandbox");
        } catch (Exception | AssertionError exception) {
            throw new WorkspacesExceptions.CreateWorkspaceException("Unable to create workspace", exception);
        }
    }

    @Test
    public void updateWorkspace() {
        try {
           var response = requestBuilderForTT2WithAuthHeader(workspaceId, token, path)
                    .statusCode(HttpStatus.SC_NO_CONTENT)
                    .body(workspacesRequest = new WorkspacesRequest(UPDATE_NAME))
                    .patch()
                    .then().log().all()
                    .extract().body().jsonPath().getList("data", WorkspacesResponse.class);
//                    .patchReturnItem("data",WorkspacesResponse.class);
            assertThat(response).isNotNull();
            assertTrue(response.stream().findFirst().get().getWorkspaceName().contains("Test_777_UPDATED"));
//            workspaceId = response.getWorkspaceId();
//            workspaceName = response.getWorkspaceName();
//            assertThat(response.getWorkspaceId()).isNotNull();
//            assertThat(response.getWorkspaceName()).isEqualTo(UPDATE_NAME);
//            assertThat(response.getWorkspaceTopology().getTopologyName()).isEqualTo("Sandbox");
        } catch (Exception | AssertionError exception) {
            throw new WorkspacesExceptions.UpdateWorkspaceException("Unable to update workspace", exception);
        }
    }

//    @Test
    public Integer getWorkspaceIdAfterUpdate() {
        try {
            return workspaceId = requestBuilderForTT2WithAuthHeader(token, path)
                    .statusCode(HttpStatus.SC_OK)
                    .getReturnItem("data",WorkspacesResponse.class)
                    .getWorkspaceId();
        } catch (Exception | AssertionError exception) {
            throw new WorkspacesExceptions.GetWorkspaceException("Unable to get workspace", exception);
        }
    }

    @Test
    public List<WorkspacesResponse> deleteWorkspace() {
        try {
            return requestBuilderForTT2WithAuthHeader(this.getWorkspaceIdAfterUpdate(), token, path)
                    .statusCode(HttpStatus.SC_NO_CONTENT)
                    .deleteReturnList("data", WorkspacesResponse.class);
        } catch (Exception | AssertionError exception) {
            if (exception.getMessage().contains(String.valueOf(HttpStatus.SC_NOT_FOUND))) {
                return Collections.emptyList();
            } else {
                throw new WorkspacesExceptions.DeleteWorkspaceException("Unable to delete workspace", exception);
            }
        }
    }

    @Test
    public void getWorkspaceAfterDelete() {
        try {
            WorkspacesResponse response = requestBuilderForTT2WithAuthHeader(token, path)
                    .statusCode(HttpStatus.SC_OK)
                    .getReturnItem("data",WorkspacesResponse.class);
            assertThat(response).isNull();
        } catch (Exception | AssertionError exception) {
            throw new WorkspacesExceptions.GetWorkspaceException("Unable to get workspace", exception);
        }
    }

}
