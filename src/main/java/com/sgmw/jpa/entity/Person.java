package com.sgmw.jpa.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author hjb
 * @date 2019/9/2
 */
//name必选，entities和columns可选
    //entities配置，则返回值包含实体；columns是返回标量；两者都配则返回2者
@SqlResultSetMapping(
        name = "personAddressResultSet",
//        entities = {
//                @EntityResult(
//                        entityClass = Person.class,
//                        fields = {
//                                @FieldResult(name = "id", column = "id"),
//                                @FieldResult(name = "firstName", column = "first_name"),
//                                @FieldResult(name = "lastName", column = "last_name"),
//                        }
//
//                ),
//                @EntityResult(
//                        entityClass = Address.class,
//                        fields = {
//                                @FieldResult(name = "id", column = "id"),
//                                @FieldResult(name = "zipCode", column = "zip_code"),
//                                @FieldResult(name = "city", column = "city"),
//                                @FieldResult(name = "street", column = "street"),
//                        }
//
//                )
//        },
      columns = {
                @ColumnResult(name = "p.id",type = Long.class),
                @ColumnResult(name = "first_name",type = String.class),
                @ColumnResult(name = "last_name",type = String.class),
                @ColumnResult(name = "zip_code",type = Long.class),
                @ColumnResult(name = "city",type = String.class),
                @ColumnResult(name = "street",type = String.class),
      }
      )
@Entity(name = "Person")
public class Person {
    private Long id;
    private String firstName;
    private String lastName;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return id.equals(person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
