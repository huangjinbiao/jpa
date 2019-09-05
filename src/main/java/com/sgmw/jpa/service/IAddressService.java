package com.sgmw.jpa.service;

import com.sgmw.jpa.entity.Address;
import com.sgmw.jpa.entity.Person;
import org.springframework.data.domain.Page;

/**
 * @author HJB
 */
public interface IAddressService {
    /**
     * add
     * @param address
     * @return
     */
    Address save(Address address);

    /**
     * update
     * @param address
     * @return
     */
    Address update(Address address);

    /**
     * get
     * @param personId
     * @return
     */
    Address get(Long personId);

    /**
     * list
     * @param page
     * @param size
     * @return
     */
    Page<Address> list(int page, int size);

    /**
     * del
     * @param id
     */
    void del(Long id);
}
