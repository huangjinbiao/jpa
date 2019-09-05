package com.sgmw.jpa.repository;

import com.sgmw.jpa.dto.UNameOnly;
import com.sgmw.jpa.dto.UserDto;
import com.sgmw.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HJB
 */
@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {

    /**
     * 用接口来投影必须找到一个条件，否则回报错误
     * @param age
     * @param pageable
     * @return
     */
    Page<UNameOnly>findByAgeGreaterThanEqual(int age,Pageable pageable);
    /**
     * DTO投影
     * 获取部分字段
     *
     * @param offset
     * @param limit
     * @return
     */
    @Query(value = "select  new com.sgmw.jpa.dto.UserDto(id,name) FROM User order by id DESC")
    List<UserDto> queryPartialUser(int offset, int limit);
}
