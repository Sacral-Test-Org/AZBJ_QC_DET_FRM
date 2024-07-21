package com.azbj.qc.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PhysicalCopyStatusRepository {

    @Modifying
    @Transactional
    @Query("UPDATE azbj_phub_qc_status_detail SET PHYSICAL_COPY_STATUS = :status WHERE policy_no = :policyNo")
    int updatePhysicalCopyStatus(@Param("policyNo") String policyNo, @Param("status") String status);
}
