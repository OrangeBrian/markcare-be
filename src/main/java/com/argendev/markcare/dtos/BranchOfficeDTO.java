package com.argendev.markcare.dtos;

import lombok.Data;

@Data
public class BranchOfficeDTO {

    private long id;
    private StoreDTO store;
    private String city;
    private String street;
    private String neighborhood;
    private int numberHeight;
}
