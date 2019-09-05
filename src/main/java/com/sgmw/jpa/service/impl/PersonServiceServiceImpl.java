package com.sgmw.jpa.service.impl;

import com.sgmw.jpa.dto.PersonDetailDto;
import com.sgmw.jpa.entity.Person;
import com.sgmw.jpa.repository.PersonRepository;
import com.sgmw.jpa.repository.em.CommonEm;
import com.sgmw.jpa.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HJB
 * @date 2019/9/2
 */
@Service
public class PersonServiceServiceImpl implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

  @Autowired
  private CommonEm commonEm;

    @Override
    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person get(Long personId) {
        return personRepository.findOneById(personId);
    }

    @Override
    public Page<Person> list(int page, int size) {
        return personRepository.findAll(PageRequest.of(page,size,Sort.by(Sort.Order.by("id"))));
    }

    @Override
    public void del(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Object> listByEm(int page, int size) {
        return commonEm.getByEm3(page,size);
    }

    @Override
    public List<Object> listByJoin(int page, int size) {
        return personRepository.listByJoin(page,size);
    }

    @Override
    public List<PersonDetailDto> listByDto(int page, int size) {
        return personRepository.listByDto(page,size);
    }
}
