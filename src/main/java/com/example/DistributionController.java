package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private DistributionRepository distributionRepository;

    /**
     * Updates a DistributionEntity's ratio
     * @param id The id of the entity
     * @param ratio The new ratio
     * @return The updated entity
     */
    @RequestMapping(value = "/{id}/{ratio}", method = RequestMethod.POST)
    public ResponseEntity postDistribution(
            @RequestParam int id,
            @RequestParam int ratio) {



        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getDistributions() {
        List<DistributionEntity> entities = (List<DistributionEntity>) distributionRepository.findAll();
        return new ResponseEntity(entities, HttpStatus.OK);
    }
}
