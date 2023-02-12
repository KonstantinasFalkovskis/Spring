package com.klix.backend.utils.exceptions;

public class WorkspacesExceptions extends RuntimeException{

    WorkspacesExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public static class CreateWorkspaceException extends WorkspacesExceptions {

        public CreateWorkspaceException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class DeleteWorkspaceException extends WorkspacesExceptions {

        public DeleteWorkspaceException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class UpdateWorkspaceException extends WorkspacesExceptions {

        public UpdateWorkspaceException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class GetWorkspaceException extends WorkspacesExceptions {

        public GetWorkspaceException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
