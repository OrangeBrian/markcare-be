package com.argendev.markcare.services.interfaces;

import com.argendev.markcare.dtos.StoreDTO;
import com.argendev.markcare.models.Store;

import java.util.List;

public interface StoreService {
    StoreDTO save(Store store);
    StoreDTO getStoreById(Long id);
    List<StoreDTO> findAllStores();
}
