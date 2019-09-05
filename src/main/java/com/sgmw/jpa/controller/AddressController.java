package com.sgmw.jpa.controller;

import com.sgmw.jpa.entity.Address;
import com.sgmw.jpa.entity.Person;
import com.sgmw.jpa.service.IAddressService;
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
@RequestMapping(value = "/v0.1/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address get(@PathVariable Long id) {
        return addressService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Address update(@RequestBody Address address, @PathVariable Long id) {
        address.setId(id);
        return addressService.update(address);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object del(@PathVariable Long id) {
        addressService.del(id);
        return new Object();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "20") int size,
                                    @RequestParam(name = "type", defaultValue = "0") int type) {
        List<Address> addressList = addressService.list(page,size).getContent();
        Map<String, Object> retMap = new HashMap<>(16);
        retMap.put("items", null == addressList ? Collections.emptyList() : addressList);
        return retMap;
    }

}
