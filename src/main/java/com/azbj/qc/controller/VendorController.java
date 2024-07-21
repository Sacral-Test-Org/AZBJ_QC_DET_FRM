package com.azbj.qc.controller;

import com.azbj.qc.service.VendorService;
import com.azbj.qc.dto.VendorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public ResponseEntity<List<VendorDTO>> getVendors() {
        List<VendorDTO> vendors = vendorService.fetchVendors();
        return ResponseEntity.ok(vendors);
    }
}
