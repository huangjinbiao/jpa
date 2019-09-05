package com.sgmw.jpa.repository.em;

import com.sgmw.jpa.dto.UNameOnly;
import com.sgmw.jpa.dto.UserDto;
import com.sgmw.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Interface used to interact with the persistence context.
 * @author HJB
 * @date 2019/9/3
 */
@Component
public class CommonEm {
    @Autowired
    private EntityManager entityManager;

//    /**
//     *UNameOnly.class必须是一个entity，否则不行,改示例就报错了
//     * @param page
//     * @param size
//     * @return
//     */
//    public List<UNameOnly> getByEm(int page,int size){
//        return entityManager.createNativeQuery("select * from User order by id limit ?1,?2",UNameOnly.class)
//                .setParameter(1,page * size)
//                .setParameter(2,size)
//                .getResultList();
//    }

    /**
     * select后面的字段必须是
     * @param page
     * @param size
     * @return
     */
    public List<UserDto> getByEm2(int page, int size){
        return entityManager.createNativeQuery("select id,age,name from User order by id  limit ?1,?2","findSimpleUser")
                .setParameter(1,page * size)
                .setParameter(2,size)
                .getResultList();
    }

    public List<Object> getByEm3(int page, int size){
        StringBuilder sqlBuilder = new StringBuilder()
       .append("select p.id,first_name,last_name,zip_code,city,street")
                .append(" FROM person p")
                .append(" LEFT JOIN person_address pa ON pa.person_id = p.id")
                .append(" LEFT JOIN address a ON pa.address_id = a.id")
                .append(" order by p.id DESC")
                .append(" limit ?1,?2");
        return entityManager.createNativeQuery(sqlBuilder.toString(),"personAddressResultSet")
                .setParameter(1,page * size)
                .setParameter(2,size)
                .getResultList();
    }


}
