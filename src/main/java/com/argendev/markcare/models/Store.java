package com.argendev.markcare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String category;
    private Integer idLegal;
    private Integer telephone;
    private String email;
    private String password;
    private boolean available;

    @OneToMany(mappedBy = "store")
    @JsonBackReference
    private Set<BranchOffice> branchOffices;
}
