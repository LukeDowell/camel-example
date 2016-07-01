package com.example.web;

import com.example.service.RatioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ldowell on 6/30/16.
 */
@RestController
public class DistributionController {
    private static final Log log = LogFactory.getLog(DistributionController.class);

    @Autowired
    private RatioService ratioService;

    @RequestMapping(value = "/{ratio}", method = RequestMethod.POST)
    public ResponseEntity postDistribution(
            @RequestParam int ratio) {
        // Need validation
        ratioService.setRatio(ratio);
        log.info(String.format("DistributionController - Setting new ratio to : %s" , ratio));
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
