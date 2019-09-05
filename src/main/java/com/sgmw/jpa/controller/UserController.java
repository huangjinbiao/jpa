package com.sgmw.jpa.controller;

import com.sgmw.jpa.entity.User;
import com.sgmw.jpa.repository.em.CommonEm;
import com.sgmw.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HJB
 * @date 2019/8/30
 */
@RestController
@RequestMapping(value = "/v0.1/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private CommonEm commonEm;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object del(@PathVariable Long id) {
        userService.del(id);
        return new Object();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "20") int size,
                                    @RequestParam(name = "type", defaultValue = "0") int type) {
        Object userList = null;
        switch (type) {
            case 0:
                userList = userService.list(page, size);
                break;
            case 1:
                userList = userService.projectionsByInterface(page, size);
                break;
            case 2:
                userList = userService.projectionsByDto(page, size);
                break;
            default:
                throw new RuntimeException("type is invalid");
        }
        Map<String, Object> retMap = new HashMap<>(16);
        retMap.put("items", null == userList ? Collections.emptyList() : userList);
        return retMap;
    }

    @RequestMapping(value = "/em", method = RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "20") int size) {

        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }

        if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        }
        Object userList2 = commonEm.getByEm2(page,size);
        Map<String, Object> retMap = new HashMap<>(16);
        retMap.put("items", null == userList2 ? Collections.emptyList() : userList2);
        return retMap;
    }
}
