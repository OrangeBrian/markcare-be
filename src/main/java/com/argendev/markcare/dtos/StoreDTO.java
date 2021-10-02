package com.argendev.markcare.dtos;

import lombok.Data;

@Data
public class StoreDTO {

    private long id;
    private String name;
    private String description;
    private String category;
    private Integer idLegal;
    private Integer telephone;
    private String email;
    private String imageUrl;
}
