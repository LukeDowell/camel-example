package com.example.service;

import com.example.SomePayload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by luke on 6/30/2016.
 */
@Service
public class SomeProcessingService {
    private static final Log log = LogFactory.getLog(SomeProcessingService.class);

    public SomePayload action(SomePayload payload, String message) {
        log.info(String.format("AnotherLoggingService - Action() - %s", payload));
        payload.setSomeString("I've been processed");
        payload.setSomeAge(payload.getSomeAge() + 1);
        return payload;
    }
}
