package com.azbj.qc.repository;

import com.azbj.qc.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findAllByBranchCodeAndBranchDeleteFlagIsNull(String branchCode);
}
