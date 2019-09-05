package com.sgmw.jpa.controller;

import com.sgmw.jpa.dto.PersonDetailDto;
import com.sgmw.jpa.entity.Person;
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
@RequestMapping(value = "/v0.1/persons")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable Long id) {
        return personService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Person update(@RequestBody Person person, @PathVariable Long id) {
        person.setId(id);
        return personService.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object del(@PathVariable Long id) {
        personService.del(id);
        return new Object();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "20") int size,
                                    @RequestParam(name = "type", defaultValue = "0") int type) {
        List<Person> personList = personService.list(page,size).getContent();
        Map<String, Object> retMap = new HashMap<>(16);
        retMap.put("items", null == personList ? Collections.emptyList() : personList);
        return retMap;
    }

    @RequestMapping(value = "/em", method = RequestMethod.GET)
    public Map<String, Object> list2(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "20") int size,
                                    @RequestParam(name = "type", defaultValue = "0") int type) {
        List<Object> personList = personService.listByEm(page,size);
        Map<String, Object> retMap = new HashMap<>(16);
        retMap.put("items", null == personList ? Collections.emptyList() : personList);
        return retMap;
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public Map<String, Object> list3(@RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "20") int size,
                                     @RequestParam(name = "type", defaultValue = "0") int type) {
        List<Object> personList = personService.listByJoin(page,size);
        Map<String, Object> retMap = new HashMap<>(16);
        retMap.put("items", null == personList ? Collections.emptyList() : personList);
        return retMap;
    }

    @RequestMapping(value = "/dto", method = RequestMethod.GET)
    public Map<String, Object> list4(@RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "20") int size,
                                     @RequestParam(name = "type", defaultValue = "0") int type) {
        List<PersonDetailDto> personList = personService.listByDto(page,size);
        Map<String, Object> retMap = new HashMap<>(16);
        retMap.put("items", null == personList ? Collections.emptyList() : personList);
        return retMap;
    }

}
