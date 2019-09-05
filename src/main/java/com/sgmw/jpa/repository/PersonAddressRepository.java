package com.sgmw.jpa.repository;

import com.sgmw.jpa.entity.Person;
import com.sgmw.jpa.entity.PersonAddress;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author HJB
 */
@Repository
public interface PersonAddressRepository extends JpaRepositoryImplementation<PersonAddress, Long> {
}
