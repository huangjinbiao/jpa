package com.sgmw.jpa.controller;

import com.sgmw.jpa.entity.Person;
import com.sgmw.jpa.entity.PersonAddress;
import com.sgmw.jpa.service.IPersonAddressService;
import com.sgmw.jpa.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HJB
 * @date 2019/9/4
 */
@RestController
@RequestMapping(value = "/v0.1/person_address")
public class PersonAddressController {

    @Autowired
    private IPersonAddressService personAddressService;

    @RequestMapping(value = "/person/{personId}/address/{addressId}", method = RequestMethod.POST)
    public PersonAddress save(@PathVariable Long personId,@PathVariable Long addressId) {
        PersonAddress personAddress = new PersonAddress();
        personAddress.setAddressId(addressId);
        personAddress.setPersonId(personId);
        return personAddressService.save(personAddress);
    }


    @RequestMapping(value = "/person/{personId}/address/{addressId}", method = RequestMethod.DELETE)
    public void del(@PathVariable Long personId,@PathVariable Long addressId) {
        personAddressService.del(personId,addressId);
    }

}
