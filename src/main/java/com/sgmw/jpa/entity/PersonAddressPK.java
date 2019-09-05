package com.sgmw.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author hjb
 * @date 2019/9/2
 */
public class PersonAddressPK implements Serializable {
    private Long personId;
    private Long addressId;

    @Column(name = "person_id")
    @Id
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Column(name = "address_id")
    @Id
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long adressId) {
        this.addressId = adressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonAddressPK that = (PersonAddressPK) o;
        return personId.equals(that.personId )&&
                addressId.equals( that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, addressId);
    }
}
