package com.sgmw.jpa.service.impl;

import com.sgmw.jpa.entity.Address;
import com.sgmw.jpa.entity.Person;
import com.sgmw.jpa.repository.AddressRepository;
import com.sgmw.jpa.repository.PersonRepository;
import com.sgmw.jpa.service.IAddressService;
import com.sgmw.jpa.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author HJB
 * @date 2019/9/2
 */
@Service
public class AddressServiceServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address save(Address address) {
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address update(Address person) {
        addressRepository.save(person);
        return person;
    }

    @Override
    public Address get(Long addressId) {
        return addressRepository.findOneById(addressId);
    }

    @Override
    public Page<Address> list(int page, int size) {
        return addressRepository.findAll(PageRequest.of(page,size,Sort.by(Sort.Order.by("id"))));
    }

    @Override
    public void del(Long id) {
        addressRepository.deleteById(id);
    }
}
