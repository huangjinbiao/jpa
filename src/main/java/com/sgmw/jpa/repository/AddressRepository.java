package com.sgmw.jpa.repository;

import com.sgmw.jpa.entity.Address;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author HJB
 */
@Repository
public interface AddressRepository extends JpaRepositoryImplementation<Address, Long> {

    Address findOneById(Long addressId);
}
