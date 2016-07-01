package com.example.service;

import org.springframework.stereotype.Service;

/**
 * Created by luke on 6/30/2016.
 */
@Service
public class RatioService {

    private int ratio;

    public RatioService() {
        this.ratio = 1;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }
}
