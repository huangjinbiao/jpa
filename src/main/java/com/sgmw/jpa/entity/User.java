package com.sgmw.jpa.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author
 * @date 2019/9/2
 */
@Entity
@SqlResultSetMapping(
        name="findSimpleUser",
        entities = {
                @EntityResult(entityClass = User.class,
                        fields = {
                                @FieldResult(name = "id",column = "id"),
                                @FieldResult(name = "name",column = "name"),
                                @FieldResult(name = "age",column = "age")
                        })
        }
)
public class User {
    private Long id;
    private String name;
    private Integer age;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id .equals( user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
