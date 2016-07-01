package com.example.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.loadbalancer.WeightedLoadBalancer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ldowell on 6/30/16.
 */
@Component
public class MyRouteBuilder extends RouteBuilder {
    private static final Log log = LogFactory.getLog(MyRouteBuilder.class);

    @Autowired
    WeightedLoadBalancer weightedLoadBalancer;

    @Override
    public void configure() throws Exception {
        log.info("MyRouteBuilder - configure()");

        from("direct:someName")
                .loadBalance(weightedLoadBalancer)
                .to("bean:anotherLoggingService?method=action")
                .to("bean:someLoggingService?method=action");
    }
}
