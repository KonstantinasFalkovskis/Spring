package com.klix.backend.data;

import com.klix.backend.models.requests.WorkspacesRequest;

import java.util.Arrays;
import java.util.List;

public class WorkspacesData {

    public static final String NAME = "Test_777";
    public static final String EMPTY_NAME = "";
    public static final String LONG_NAME = "Super_Duper_Long_Name_Which_excites_255_chars_Super_Duper_Long_Name_Which_excites_255_chars_Super_Duper_Long_Name_Which_excites_255_chars_Super_Duper_Long_Name_Which_excites_255_chars_Super_Duper_Long_Name_Which_excites_255_chars_Super_Duper_Long_Name_Which_excites_255_chars_Super_Duper_Long_Name_Which_excites_255_chars_Super_Duper_Long_Name_Which_excites_255_chars_";

    public static final String UPDATE_NAME = "Test_777_UPDATED";
    public static final WorkspacesRequest NEW_WORKSPACE = new WorkspacesRequest(UPDATE_NAME);
    public static final WorkspacesRequest NEW_WORKSPACE_NAME = new WorkspacesRequest(UPDATE_NAME);

    public static List<WorkspacesRequest> ALL_TEST_USERS = Arrays.asList(
            NEW_WORKSPACE,
            NEW_WORKSPACE_NAME
    );
}
