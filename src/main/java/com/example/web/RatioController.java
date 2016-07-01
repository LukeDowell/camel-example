package com.example.web;

import com.example.service.RatioService;
import com.example.service.TicketApi;
import com.example.service.AnotherLoggingService;
import com.example.service.SomeLoggingService;
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
    TicketApi ticketApi;


    @RequestMapping("/")
    public ResponseEntity ticketApiCall() {
        ticketApi.action("Some String");
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/{ratio}", method = RequestMethod.POST)
    public ResponseEntity postDistribution(
            @RequestParam int id,
            @RequestParam int ratio) {

        switch(id) {
            case 1:
                ratioService.setCachedRatioOne(ratio);
                break;

            default:
                ratioService.
                break;
        }

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
