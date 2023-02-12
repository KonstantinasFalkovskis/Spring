package com.klix.backend.data;

import lombok.Getter;

public class GlobalConstants {

    @Getter
    public enum ErrorMessages {
        ERROR_FIELD("workspace_name."),
        ERROR_MESSAGE("workspace name is too long."),
        ERROR_CODE("WORKSPACE_NAME_IS_TOO_LONG."),
        ERROR_TYPE("VALIDATION_ERROR");

        private String ErrorMessages;

        ErrorMessages(String ErrorMessages) {
            this.ErrorMessages = ErrorMessages;
        }
    }
}
