package com.azbj.qc.service;

import com.azbj.qc.repository.PhysicalCopyStatusRepository;
import com.azbj.qc.dto.PhysicalCopyStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhysicalCopyStatusService {

    @Autowired
    private PhysicalCopyStatusRepository repository;

    @Transactional
    public boolean updatePhysicalCopyStatus(PhysicalCopyStatusDTO statusDTO) {
        // Validate the input data
        if (statusDTO == null || statusDTO.getPolicyNo() == null || statusDTO.getPhysicalCopyStatus() == null) {
            throw new IllegalArgumentException("Invalid input data");
        }

        String physicalCopyStatus = statusDTO.getPhysicalCopyStatus();
        if (!"Y".equals(physicalCopyStatus) && !"N".equals(physicalCopyStatus)) {
            throw new IllegalArgumentException("Choose any one of the above options");
        }

        // Update the physical copy status in the database
        boolean isUpdated = repository.updatePhysicalCopyStatus(statusDTO);

        // Commit the transaction if successful
        if (isUpdated) {
            return true;
        } else {
            throw new RuntimeException("Data Not Updated");
        }
    }
}
