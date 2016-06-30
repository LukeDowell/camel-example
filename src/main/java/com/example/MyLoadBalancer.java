package com.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.processor.loadbalancer.WeightedLoadBalancer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by ldowell on 6/30/16.
 */
public class MyLoadBalancer extends WeightedLoadBalancer {
    private Log log = LogFactory.getLog(MyLoadBalancer.class);

    public MyLoadBalancer(List<Integer> distributionRatios) {
        super(distributionRatios);
        log.info("MyLoadBalancer - constructor()");
    }

    @Override
    protected Processor chooseProcessor(List<Processor> list, Exchange exchange) {
        log.info("MyLoadBalancer - chooseProcessor()");
        return null;
    }
}
