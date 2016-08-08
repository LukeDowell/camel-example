package com.example.config;

import com.example.service.ExampleApi;
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

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CamelContext camelContext;

    @Bean
    ExampleApi exampleApi() throws Exception {
        // Create a proxy so that the endpoint is hit whenever we make a call to ExampleApi
        Endpoint endpoint = camelContext.getEndpoint("direct:someName");
        ExampleApi exampleApi = ProxyHelper.createProxy(endpoint, ExampleApi.class);
        return exampleApi;
    }

    @Bean
    WeightedLoadBalancer weightedLoadBalancer() {
        Integer[] ratioArray = {1, 2};
        List<Integer> ratios = Arrays.asList(ratioArray);
        return new WeightedRoundRobinLoadBalancer(ratios);
    }
}
