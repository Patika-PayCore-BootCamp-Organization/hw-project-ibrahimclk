package com.patika.paycore.DebitCardManagement.model;

import lombok.Data;

@Data
public class CustomerDTO {

    private String firstname;
    private String lastname;
    private String gender;
    private Integer age;
    private String phone;
    private String email;

}
