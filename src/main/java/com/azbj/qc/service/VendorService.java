package com.azbj.qc.service;

import com.azbj.qc.dto.VendorDTO;
import com.azbj.qc.repository.VendorRepository;
import com.azbj.qc.models.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public List<VendorDTO> fetchVendors(String branchCode) {
        List<Vendor> vendors = vendorRepository.findAllByBranchCodeAndBranchDeleteFlagIsNull(branchCode);
        return vendors.stream()
                .map(vendor -> new VendorDTO(vendor.getVendorCode(), vendor.getVendorName()))
                .collect(Collectors.toList());
    }
}
