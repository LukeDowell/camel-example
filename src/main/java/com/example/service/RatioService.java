package com.example.service;

import org.apache.camel.processor.loadbalancer.DistributionRatio;
import org.apache.camel.processor.loadbalancer.WeightedLoadBalancer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ldowell on 7/1/16.
 */
@Service
public class RatioService {
    private static final Log log = LogFactory.getLog(RatioService.class);

    @Autowired
    private WeightedLoadBalancer weightedLoadBalancer;

    private Integer[] cachedRatios = new Integer[] { 1 , 2 };

    /**
     *
     * @param index
     * @param value
     */
    public void updateRatio(int index, int value) {
        log.info(String.format("RatioService - updateRatio - Attempting to update index %s with value %s", index, value));

        if(index > cachedRatios.length) {
            throw new ArrayIndexOutOfBoundsException(); // Don't increase the size of the array
        }

        if(cachedRatios[index] != value) {
            cachedRatios[index] = value;
            updateRuntimeDistribution(Arrays.asList(cachedRatios));
        }
    }

    /**
     *
     * @param index
     * @return
     */
    public int getRatio(int index) {
        return cachedRatios[index];
    }

    /**
     * This is is directly copied from WeightedLoadBalancer.loadRuntimeRatios
     * @param distributionRatios
     */
    private void updateRuntimeDistribution(List<Integer> distributionRatios) {
        ArrayList<DistributionRatio> runtimeRatios = new ArrayList<>();
        int position = 0;
        Iterator i$ = distributionRatios.iterator();

        while(i$.hasNext()) {
            Integer value = (Integer)i$.next();
            runtimeRatios.add(new DistributionRatio(position++, value.intValue()));
        }

        weightedLoadBalancer.setDistributionRatioList(distributionRatios);
        weightedLoadBalancer.setRuntimeRatios(runtimeRatios);

        log.info("RatioService - updateRuntimeDistribution - Ratios updated");
    }
}
