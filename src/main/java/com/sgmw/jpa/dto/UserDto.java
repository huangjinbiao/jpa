package com.sgmw.jpa.dto;

import java.util.Objects;

/**Class-based Projections (DTOs)
 *  DTO Data Transfer Objects
 *  部分数据DTO对象
 * @author HJB
 * @date 2019/9/2
 */

public class UserDto  {
    private  Long id;
    private  String name;
    public UserDto(){
        //default construction
    }

    public UserDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

     public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
