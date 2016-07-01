package com.example.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by luke on 6/30/2016.
 */
@Service
public class SomeLoggingService {
    private static final Log log = LogFactory.getLog(SomeLoggingService.class);

    private String action() {
        log.info("SomeLoggingService - Action()");
        return "OH OKAY";
    }
}
