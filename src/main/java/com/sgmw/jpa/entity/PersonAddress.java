package com.sgmw.jpa.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author hjb
 * @date 2019/9/2
 */
@Entity
@Table(name = "person_address", schema = "jpa-test", catalog = "")
@IdClass(PersonAddressPK.class)
public class PersonAddress {
    private Long personId;
    private Long addressId;

    @Id
    @Column(name = "person_id")
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Id
    @Column(name = "address_id")
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonAddress that = (PersonAddress) o;
        return personId.equals(that.personId) &&
                addressId .equals( that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, addressId);
    }
}
