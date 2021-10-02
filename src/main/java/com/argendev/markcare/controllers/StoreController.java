package com.argendev.markcare.controllers;

import com.argendev.markcare.dtos.StoreDTO;
import com.argendev.markcare.models.Store;
import com.argendev.markcare.services.interfaces.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
@CrossOrigin(origins = "https://markcare-fe.vercel.app/")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/save")
    public ResponseEntity<StoreDTO> createStore(@RequestBody Store store) {
        return new ResponseEntity<>(storeService.save(store), HttpStatus.OK);
    }

    @GetMapping("/shops")
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        return new ResponseEntity<>(storeService.findAllStores(), HttpStatus.OK);
    }
}
