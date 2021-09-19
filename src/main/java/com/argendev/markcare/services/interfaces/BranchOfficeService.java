package com.argendev.markcare.services.interfaces;

import com.argendev.markcare.dtos.BranchOfficeDTO;
import com.argendev.markcare.models.BranchOffice;

import java.util.List;

public interface BranchOfficeService {
    BranchOfficeDTO save(BranchOffice branchOffice);
    List<BranchOfficeDTO> getBranchOfficesByStoreId(Long id);
}
