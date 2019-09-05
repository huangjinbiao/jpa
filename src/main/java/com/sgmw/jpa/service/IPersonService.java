package com.sgmw.jpa.service;

import com.sgmw.jpa.dto.PersonDetailDto;
import com.sgmw.jpa.entity.Person;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author HJB
 */
public interface IPersonService {
    /**
     * add
     * @param person
     * @return
     */
    Person save(Person person);

    /**
     * update
     * @param person
     * @return
     */
    Person update(Person person);

    /**
     * get
     * @param personId
     * @return
     */
    Person get(Long personId);

    /**
     * list
     * @param page
     * @param size
     * @return
     */
    Page<Person> list(int page, int size);

    /**
     * del
     * @param id
     */
    void del(Long id);

    List<Object> listByEm(int page, int size);

    List<Object> listByJoin(int page, int size);

    List<PersonDetailDto> listByDto(int page, int size);
}
