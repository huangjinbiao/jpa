package com.sgmw.jpa.service.impl;

import com.sgmw.jpa.entity.PersonAddress;
import com.sgmw.jpa.repository.PersonAddressRepository;
import com.sgmw.jpa.service.IPersonAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hjb
 * @date 2019/9/4
 */
@Service
public class PersonAddressService implements IPersonAddressService {

    @Autowired
    private PersonAddressRepository personAddressRepository;

    @Override
    public PersonAddress save(PersonAddress personAddress) {
        personAddressRepository.save(personAddress);
        return personAddress;
    }

    @Override
    public void del(Long personId, Long addressId) {
        PersonAddress personAddress = new PersonAddress();
        personAddress.setPersonId(personId);
        personAddress.setAddressId(addressId);
        personAddressRepository.delete(personAddress);
    }


}
