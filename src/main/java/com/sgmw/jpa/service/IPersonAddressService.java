package com.sgmw.jpa.service;

import com.sgmw.jpa.entity.Person;
import com.sgmw.jpa.entity.PersonAddress;
import org.springframework.data.domain.Page;

/**
 * @author HJB
 */
public interface IPersonAddressService {
    /**
     * add
     * @param personAddress
     * @return
     */
    PersonAddress save(PersonAddress personAddress);

    /**
     * del
     * @param personId
     * @param addressId
     */
    void del(Long personId, Long addressId);
}
