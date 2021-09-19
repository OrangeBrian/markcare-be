package com.argendev.markcare.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
