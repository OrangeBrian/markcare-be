package com.argendev.markcare.repositories;

import com.argendev.markcare.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findStoreById(Long id);
}
