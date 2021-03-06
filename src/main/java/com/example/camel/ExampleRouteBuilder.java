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
public class ExampleRouteBuilder extends RouteBuilder {
    private static final Log log = LogFactory.getLog(ExampleRouteBuilder.class);

    @Autowired
    WeightedLoadBalancer weightedLoadBalancer;

    @Override
    public void configure() throws Exception {
        log.info("MyRouteBuilder - configure()");

//        from("timer:someTimer")
//                .to("direct:someName");

        from("direct:someName")
                .loadBalance(weightedLoadBalancer)
                .to("bean:anotherProcessingService?method=action")
                .to("bean:someProcessingService?method=action");
    }
}
