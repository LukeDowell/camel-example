package com.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 6/30/16.
 */
@Repository
public interface DistributionRepository extends CrudRepository<DistributionEntity, Long> {


}
