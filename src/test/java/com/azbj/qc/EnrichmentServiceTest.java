package com.azbj.qc;

import com.azbj.qc.service.EnrichmentService;
import com.azbj.qc.model.Enrichment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class EnrichmentServiceTest {

    @Mock
    private EnrichmentService enrichmentService;

    @InjectMocks
    private EnrichmentServiceTest enrichmentServiceTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEnrichmentDetails_Success() {
        String applicationNumber = "APP123";
        Enrichment enrichment = new Enrichment();
        enrichment.setApplicationNumber(applicationNumber);
        when(enrichmentService.getEnrichmentDetails(anyString())).thenReturn(Optional.of(enrichment));

        Optional<Enrichment> result = enrichmentService.getEnrichmentDetails(applicationNumber);
        assertTrue(result.isPresent());
        assertEquals(applicationNumber, result.get().getApplicationNumber());
    }

    @Test
    public void testGetEnrichmentDetails_NotFound() {
        String applicationNumber = "APP123";
        when(enrichmentService.getEnrichmentDetails(anyString())).thenReturn(Optional.empty());

        Optional<Enrichment> result = enrichmentService.getEnrichmentDetails(applicationNumber);
        assertFalse(result.isPresent());
    }

    @Test
    public void testGetEnrichmentDetails_NullApplicationNumber() {
        when(enrichmentService.getEnrichmentDetails(null)).thenReturn(Optional.empty());

        Optional<Enrichment> result = enrichmentService.getEnrichmentDetails(null);
        assertFalse(result.isPresent());
    }
}
