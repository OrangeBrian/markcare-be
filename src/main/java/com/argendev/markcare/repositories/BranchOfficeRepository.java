package com.argendev.markcare.repositories;

import com.argendev.markcare.models.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Long> {
    List<BranchOffice> findAllByStoreId(Long id);
}
