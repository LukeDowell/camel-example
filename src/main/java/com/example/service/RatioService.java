package com.example.service;

import org.apache.camel.processor.loadbalancer.WeightedLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldowell on 7/1/16.
 */
@Service
public class RatioService {

    @Autowired
    private WeightedLoadBalancer weightedLoadBalancer;

    private int cachedRatioOne = 1;
    private int cachedRatioTwo = 2;

    public int getCachedRatioOne() {
        return cachedRatioOne;
    }

    public void setCachedRatioOne(int cachedRatioOne) {
        this.cachedRatioOne = cachedRatioOne;
    }

    public int getCachedRatioTwo() {
        return cachedRatioTwo;
    }

    public void setCachedRatioTwo(int cachedRatioTwo) {
        this.cachedRatioTwo = cachedRatioTwo;
    }
}
