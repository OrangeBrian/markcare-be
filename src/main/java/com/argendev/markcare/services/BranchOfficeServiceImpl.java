package com.argendev.markcare.services;

import com.argendev.markcare.dtos.BranchOfficeDTO;
import com.argendev.markcare.dtos.StoreDTO;
import com.argendev.markcare.models.BranchOffice;
import com.argendev.markcare.models.Store;
import com.argendev.markcare.repositories.BranchOfficeRepository;
import com.argendev.markcare.services.interfaces.BranchOfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

    private final BranchOfficeRepository branchOfficeRepository;
    private final ModelMapper mapper;

    public BranchOfficeServiceImpl(BranchOfficeRepository branchOfficeRepository, ModelMapper mapper) {
        this.branchOfficeRepository = branchOfficeRepository;
        this.mapper = mapper;
    }

    @Override
    public BranchOfficeDTO save(BranchOffice branchOffice) {
        return mapper.map(branchOfficeRepository.save(branchOffice), BranchOfficeDTO.class);
    }

    @Override
    public List<BranchOfficeDTO> getBranchOfficesByStoreId(Long id) {
        List<BranchOffice> branchOffices = branchOfficeRepository.findAllByStoreId(id);
        List<BranchOfficeDTO> branchOfficeDTOS = new ArrayList<>();
        for (BranchOffice branchOffice : branchOffices) {
            branchOfficeDTOS.add(mapper.map(branchOffice, BranchOfficeDTO.class));
        }
        return branchOfficeDTOS;
    }

}
