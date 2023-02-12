package com.klix.backend.utils.exceptions;

public class AgentTokensExceptions extends RuntimeException{

    AgentTokensExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public static class CreateAgentTokenException extends AgentTokensExceptions {

        public CreateAgentTokenException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class DeleteAgentTokenException extends AgentTokensExceptions {

        public DeleteAgentTokenException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class GetAgentTokenException extends AgentTokensExceptions {

        public GetAgentTokenException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
