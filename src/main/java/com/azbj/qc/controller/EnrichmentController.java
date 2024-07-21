package com.azbj.qc.controller;

import com.azbj.qc.service.EnrichmentService;
import com.azbj.qc.model.Enrichment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EnrichmentController {

    @Autowired
    private EnrichmentService enrichmentService;

    @GetMapping("/enrichment-details")
    public ResponseEntity<Optional<Enrichment>> getEnrichmentDetails(@RequestParam String applicationNumber) {
        Optional<Enrichment> enrichmentDetails = enrichmentService.getEnrichmentDetails(applicationNumber);
        if (enrichmentDetails.isPresent()) {
            return ResponseEntity.ok(enrichmentDetails);
        } else {
            return ResponseEntity.status(404).body(Optional.empty());
        }
    }
}
