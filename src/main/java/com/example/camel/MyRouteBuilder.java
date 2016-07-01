package com.example.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldowell on 6/30/16.
 */
@Component
public class MyRouteBuilder extends RouteBuilder {
    private static final Log log = LogFactory.getLog(MyRouteBuilder.class);

    @Override
    public void configure() throws Exception {
        log.info("MyRouteBuilder - configure()");

        List<Integer> ratios = new ArrayList<>();
        ratios.add(2);
        ratios.add(1);

        from("timer:someTimer")
                .loadBalance(new MyLoadBalancer(ratios))
                .to("bean:anotherLoggingService?method=action")
                .to("bean:someLoggingService?method=action");
    }
}