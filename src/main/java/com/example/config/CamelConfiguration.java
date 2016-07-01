package com.example.config;

import com.example.service.TicketApi;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.component.bean.ProxyHelper;
import org.apache.camel.processor.loadbalancer.WeightedLoadBalancer;
import org.apache.camel.processor.loadbalancer.WeightedRoundRobinLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ldowell on 7/1/16.
 */
@Configuration
public class CamelConfiguration {

    @Autowired
    CamelContext camelContext;

    @Bean
    TicketApi ticketApi() throws Exception {
        // Create a proxy so that the endpoint is hit whenever we call TicketApi
        Endpoint endpoint = camelContext.getEndpoint("direct:someName");
        return ProxyHelper.createProxy(endpoint, TicketApi.class);
    }

    @Bean
    WeightedLoadBalancer weightedLoadBalancer() {
        Integer[] ratioArray = {1, 2};
        List<Integer> ratios = Arrays.asList(ratioArray);
        return new WeightedRoundRobinLoadBalancer(ratios);
    }
}
