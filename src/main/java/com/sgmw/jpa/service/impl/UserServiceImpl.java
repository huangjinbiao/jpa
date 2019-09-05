package com.sgmw.jpa.service.impl;

import com.sgmw.jpa.dto.UNameOnly;
import com.sgmw.jpa.dto.UserDto;
import com.sgmw.jpa.entity.User;
import com.sgmw.jpa.repository.UserRepository;
import com.sgmw.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author HJB
 * @date 2019/9/2
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User get(Long id) {
       Optional<User> userOption =userRepository.findById(id);
       if(userOption.isPresent()){
           return userOption.get();
       }
       return null;
    }

    @Override
    public User update(User user) {
        User userInDb = this.get(user.getId());
        if(null == userInDb){
            throw new RuntimeException(String.format("user_id=%s is not found",user.getId()));
        }
        if(!StringUtils.isEmpty(user.getAge())) {
            userInDb.setAge(user.getAge());
        }
        if(!StringUtils.isEmpty(user.getName())) {
            userInDb.setName(user.getName());
        }
        userRepository.save(userInDb);
        return userInDb;
    }

    @Override
    public List<User> list(int page,int size) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC,"id"));
        Page<User> userPage = userRepository.findAll(PageRequest.of(page,size,sort));

        return userPage.getContent();
    }

    @Override
    public void del(Long id) {
        User userInDb = this.get(id);
        if(null == userInDb){
            throw new RuntimeException(String.format("user_id=%s is not found",id));
        }
        userRepository.delete(userInDb);
    }

    @Override
    public List<UNameOnly> projectionsByInterface(int page, int size) {
        return userRepository.findByAgeGreaterThanEqual(0,PageRequest.of(page,size)).getContent();
    }

    @Override
    public List<UserDto> projectionsByDto(int page, int size) {
        if(page < 0 || size <=0){
            throw new RuntimeException("page or size is invalid");
        }
        int offset = page <=0 ?0:page*size;
        int limit = size;
        return userRepository.queryPartialUser(offset,limit);
    }
}
