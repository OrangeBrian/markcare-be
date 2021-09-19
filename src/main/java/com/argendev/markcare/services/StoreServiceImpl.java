package com.argendev.markcare.services;

import com.argendev.markcare.dtos.StoreDTO;
import com.argendev.markcare.models.Store;
import com.argendev.markcare.repositories.StoreRepository;
import com.argendev.markcare.services.interfaces.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final ModelMapper mapper;

    public StoreServiceImpl(StoreRepository storeRepository, ModelMapper mapper) {
        this.storeRepository = storeRepository;
        this.mapper = mapper;
    }

    @Override
    public StoreDTO save(Store store) {
        return mapper.map(storeRepository.save(store), StoreDTO.class);
    }

    @Override
    public StoreDTO getStoreById(Long id) {
        return mapper.map(storeRepository.findStoreById(id), StoreDTO.class);
    }

    @Override
    public List<StoreDTO> findAllStores() {
        List<Store> stores = storeRepository.findAll();
        List<StoreDTO> storeDTOS = new ArrayList<>();
        for (Store store : stores) {
            storeDTOS.add(mapper.map(store, StoreDTO.class));
        }
        return storeDTOS;
    }


}
