package com.klix.backend.config;


import com.klix.backend.data.DataCleanup;
import com.klix.backend.data.DataPreparation;
import com.klix.backend.utils.services.AgentsUtils;
import com.klix.backend.utils.services.WorkspacesUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApiUtils {

    @Bean
    @Scope("prototype")
    DataPreparation dataPreparation() {
        return new DataPreparation();
    }

    @Bean
    @Scope("prototype")
    DataCleanup dataCleanup() {
        return new DataCleanup();
    }

    @Bean
    @Scope("prototype")
    WorkspacesUtils workspacesUtils() {
        return new WorkspacesUtils();
    }

    @Bean
    @Scope("prototype")
    AgentsUtils agentsUtils() {
        return new AgentsUtils();
    }
}
