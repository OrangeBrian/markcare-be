package com.argendev.markcare.controllers;

import com.argendev.markcare.dtos.BranchOfficeDTO;
import com.argendev.markcare.models.BranchOffice;
import com.argendev.markcare.services.interfaces.BranchOfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch_office")
public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    public BranchOfficeController(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping("/save")
    public ResponseEntity<BranchOfficeDTO> createBranchOffice(@RequestBody BranchOffice branchOffice) {
        return new ResponseEntity<>(branchOfficeService.save(branchOffice), HttpStatus.OK);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<List<BranchOfficeDTO>> getBranchOfficesByStoreId(@PathVariable Long id){
        return new ResponseEntity<>(branchOfficeService.getBranchOfficesByStoreId(id), HttpStatus.OK);
    }
}
