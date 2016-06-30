package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ldowell on 6/30/16.
 */
@Component
public class MyLoggingBean {
    private static final Log log = LogFactory.getLog(MyLoggingBean.class);

    public MyLoggingBean() {}

    public String action() {
        log.info("Holy Sheet");
        return "swag";
    }
}
