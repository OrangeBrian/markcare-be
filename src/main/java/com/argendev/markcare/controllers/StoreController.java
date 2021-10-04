package com.argendev.markcare.controllers;

import com.argendev.markcare.dtos.StoreDTO;
import com.argendev.markcare.exceptions.StoreException;
import com.argendev.markcare.models.Store;
import com.argendev.markcare.services.interfaces.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
@CrossOrigin(origins = "*")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/save")
    public ResponseEntity<StoreDTO> createStore(@RequestBody Store store) {
        try {
            return new ResponseEntity<>(storeService.save(store), HttpStatus.OK);
        } catch (Exception e) {
            throw new StoreException("CREATE store failed: " + e.getMessage());
        }
    }

    @GetMapping("/shops")
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        try {
            return new ResponseEntity<>(storeService.findAllStores(), HttpStatus.OK);
        } catch (Exception e) {
            throw new StoreException("GET all stores failed: " + e.getMessage());
        }
    }
}
