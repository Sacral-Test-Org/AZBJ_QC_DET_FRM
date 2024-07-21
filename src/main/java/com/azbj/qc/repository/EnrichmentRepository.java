package com.azbj.qc.repository;

import com.azbj.qc.model.Enrichment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrichmentRepository extends JpaRepository<Enrichment, Long> {

    @Query("SELECT e FROM Enrichment e WHERE e.applicationNumber = :applicationNumber")
    Optional<Enrichment> findEnrichmentDetails(@Param("applicationNumber") String applicationNumber);
}
