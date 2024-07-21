package com.azbj.qc.repository;

import com.azbj.qc.model.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatchRepository extends JpaRepository<Dispatch, Long> {

    @Override
    Dispatch save(Dispatch dispatch);

    @Query("SELECT d FROM Dispatch d WHERE d.contractId = :contractId")
    Dispatch findDispatchDetails(@Param("contractId") String contractId);

    @Query("DELETE FROM Dispatch d")
    void clearDispatchDetails();
}
