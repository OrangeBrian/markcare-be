package com.argendev.markcare.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="branch_office")
@Data
public class BranchOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;

    private String city;
    private String street;
    private String neighborhood;
    private int numberHeight;
    private String latitude;
    private String longitude;
}
