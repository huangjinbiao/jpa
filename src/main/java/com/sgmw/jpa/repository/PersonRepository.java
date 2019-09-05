package com.sgmw.jpa.repository;

import com.sgmw.jpa.dto.PersonDetailDto;
import com.sgmw.jpa.dto.UNameOnly;
import com.sgmw.jpa.dto.UserDto;
import com.sgmw.jpa.entity.Person;
import com.sgmw.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HJB
 */
@Repository
public interface PersonRepository extends JpaRepositoryImplementation<Person, Long> {

    Person findOneById(Long personId);

    @Query(value = "SELECT p.id,first_name,last_name,zip_code,city,street FROM person p LEFT JOIN person_address pa ON pa.person_id = p.id LEFT JOIN address a ON pa.address_id = a.id ORDER BY p.id ",nativeQuery = true)
    List<Object> listByJoin(int page, int size);

    /**
     * dto仅限于本实体，或者是本实体的子集，超过则无能为力
     * @param page
     * @param size
     * @return
     */
    @Query(value = "SELECT new com.sgmw.jpa.dto.PersonDetailDto(p.id,first_name,city) FROM Person p LEFT JOIN Person_address pa fetch pa.person_id = p.id LEFT JOIN Address a fetch pa.address_id = a.id ORDER BY p.id ",nativeQuery = false)
    List<PersonDetailDto> listByDto(int page, int size);
}
