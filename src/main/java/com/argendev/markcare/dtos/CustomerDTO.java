package com.argendev.markcare.dtos;

import lombok.Data;

@Data
public class CustomerDTO {

    private String username;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private Integer cellphone;
    private Integer idLegal;
    private String country;
}
