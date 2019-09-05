package com.sgmw.jpa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ColumnResult;

/**
 * @author HJB
 * @date 2019/9/5
 */
@Data
@NoArgsConstructor
public class PersonDetailDto {
//    @ColumnResult(name = "p.id",type = Long.class),
//    @ColumnResult(name = "first_name",type = String.class),
//    @ColumnResult(name = "last_name",type = String.class),
//    @ColumnResult(name = "zip_code",type = Long.class),
//    @ColumnResult(name = "city",type = String.class),
//    @ColumnResult(name = "street",type = String.class),

    private Long id;
    private String firstName;
    private String city;

    public PersonDetailDto(Long id,String firstName,String city){
        this.id = id;
        this.firstName = firstName;
        this.city = city;
    }


}
