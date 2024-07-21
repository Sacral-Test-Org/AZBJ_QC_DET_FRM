package com.azbj.qc.controller;

import com.azbj.qc.dto.PhysicalCopyStatusDTO;
import com.azbj.qc.service.PhysicalCopyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/physical-copy-status")
public class PhysicalCopyStatusController {

    @Autowired
    private PhysicalCopyStatusService physicalCopyStatusService;

    @PostMapping("/update")
    public ResponseEntity<String> updatePhysicalCopyStatus(@RequestBody PhysicalCopyStatusDTO physicalCopyStatusDTO) {
        if (!"Y".equals(physicalCopyStatusDTO.getStatus()) && !"N".equals(physicalCopyStatusDTO.getStatus())) {
            return new ResponseEntity<>("Choose any one of the above options.", HttpStatus.BAD_REQUEST);
        }

        boolean isUpdated = physicalCopyStatusService.updatePhysicalCopyStatus(physicalCopyStatusDTO);

        if (isUpdated) {
            return new ResponseEntity<>("Status updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data Not Updated.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
