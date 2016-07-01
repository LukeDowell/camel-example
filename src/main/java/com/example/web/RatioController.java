package com.example.web;

import com.example.service.ExampleApi;
import com.example.service.RatioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ldowell on 6/30/16.
 */
@RestController
public class RatioController {
    private static final Log log = LogFactory.getLog(RatioController.class);

    @Autowired
    RatioService ratioService;

    @Autowired
    ExampleApi exampleApi;


    @RequestMapping("/")
    public ResponseEntity ticketApiCall() {
        exampleApi.action("Some String");
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity postDistribution(
            @RequestParam int index,
            @RequestParam int ratio) {

        ratioService.updateRatio(index, ratio);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
