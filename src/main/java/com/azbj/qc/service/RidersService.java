package com.azbj.qc.service;

import com.azbj.qc.repository.RidersRepository;
import com.azbj.qc.model.Rider;
import com.azbj.qc.dto.RiderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RidersService {

    @Autowired
    private RidersRepository ridersRepository;

    public Rider saveCoverDetails(RiderDTO riderDTO) {
        // Validate input
        if (riderDTO.getCoverCode() == null || riderDTO.getCoverCode().isEmpty()) {
            throw new IllegalArgumentException("Cover code is mandatory");
        }
        if (riderDTO.getSumInsured() == null || riderDTO.getBenefitTerm() == null || riderDTO.getPremiumTerm() == null) {
            throw new IllegalArgumentException("Sum insured, benefit term, and premium term must be numeric values");
        }

        // Convert RiderDTO to Rider
        Rider rider = new Rider();
        rider.setCoverCode(riderDTO.getCoverCode());
        rider.setSumInsured(riderDTO.getSumInsured());
        rider.setBenefitTerm(riderDTO.getBenefitTerm());
        rider.setPremiumTerm(riderDTO.getPremiumTerm());

        // Save using repository
        return ridersRepository.save(rider);
    }
}
