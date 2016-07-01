package com.example.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by luke on 6/30/2016.
 */
@Service
public class AnotherLoggingService{
    private static final Log log = LogFactory.getLog(AnotherLoggingService.class);

    public String action(Object... arguments) {
        log.info(String.format("AnotherLoggingService - Action() - %s", arguments));
        return "Alrighty Then";
    }
}
