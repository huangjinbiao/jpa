package com.sgmw.jpa.service;

import com.sgmw.jpa.dto.UNameOnly;
import com.sgmw.jpa.dto.UserDto;
import com.sgmw.jpa.entity.User;

import java.util.List;

/**
 * @author HJB
 */
public interface IUserService {

    /**
     * 增
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 删
     * @param id
     * @return
     */
     User get(Long id);

    /**
     * update
     * @param user
     * @return
     */
    User update(User user);

    /**
     * list
     * @param page
     * @param size
     * @return
     */
    List<User> list(int page,int size);

    /**
     * del
     * @param id
     */
    void del(Long id);

    /**
     * projections
     * @param page
     * @param size
     * @return
     */
    List<UNameOnly> projectionsByInterface(int page, int size);

    /**
     * projection
     * @param page
     * @param size
     * @return
     */
    List<UserDto> projectionsByDto(int page, int size);
}
