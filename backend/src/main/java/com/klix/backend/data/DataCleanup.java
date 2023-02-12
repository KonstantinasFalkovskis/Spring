package com.klix.backend.data;

import com.klix.backend.utils.services.AgentsUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class DataCleanup {

    @Autowired
    public AgentsUtils agentsUtils;

    public void deleteAgentToken(Integer id) {
        agentsUtils.deleteAgentToken(id);
    }
}

