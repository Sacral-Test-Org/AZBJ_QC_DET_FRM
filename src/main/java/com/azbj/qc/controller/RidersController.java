package com.azbj.qc.controller;

import com.azbj.qc.dto.RiderDTO;
import com.azbj.qc.service.RidersService;
import com.azbj.qc.models.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/riders")
public class RidersController {

    @Autowired
    private RidersService ridersService;

    @PostMapping("/save")
    public ResponseEntity<Rider> saveCoverDetails(@RequestBody RiderDTO riderDTO) {
        // Validate input
        if (riderDTO.getCoverCode() == null || riderDTO.getCoverCode().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Double.parseDouble(riderDTO.getSumInsured());
            Integer.parseInt(riderDTO.getBenefitTerm());
            Integer.parseInt(riderDTO.getPremiumTerm());
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }

        // Call the service to save the cover details
        Rider savedRider = ridersService.saveCoverDetails(riderDTO);
        return ResponseEntity.ok(savedRider);
    }
}
