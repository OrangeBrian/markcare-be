package com.argendev.markcare.controllers;

import com.argendev.markcare.dtos.BranchOfficeDTO;
import com.argendev.markcare.exceptions.BranchOfficeException;
import com.argendev.markcare.models.BranchOffice;
import com.argendev.markcare.services.interfaces.BranchOfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch_office")
@CrossOrigin(origins = "*")
public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    public BranchOfficeController(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping("/save")
    public ResponseEntity<BranchOfficeDTO> createBranchOffice(@RequestBody BranchOffice branchOffice) {
        try {
            return new ResponseEntity<>(branchOfficeService.save(branchOffice), HttpStatus.OK);
        } catch (Exception e) {
            throw new BranchOfficeException("CREATE branch office failed: " + e.getMessage());
        }
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<List<BranchOfficeDTO>> getBranchOfficesByStoreId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(branchOfficeService.getBranchOfficesByStoreId(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new BranchOfficeException("GET branch offices by store id " + id + " failed: " + e.getMessage());
        }
    }
}
