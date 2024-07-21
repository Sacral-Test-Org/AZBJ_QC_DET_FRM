package com.azbj.qc.service;

import com.azbj.qc.repository.EnrichmentRepository;
import com.azbj.qc.model.Enrichment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrichmentService {

    @Autowired
    private EnrichmentRepository enrichmentRepository;

    public Optional<Enrichment> getEnrichmentDetails(String applicationNumber) {
        return enrichmentRepository.findEnrichmentDetails(applicationNumber);
    }
}
