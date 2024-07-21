package com.azbj.qc;

import com.azbj.qc.service.VendorService;
import com.azbj.qc.dto.VendorDTO;
import com.azbj.qc.repository.VendorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VendorServiceTest {

    @Mock
    private VendorRepository vendorRepository;

    @InjectMocks
    private VendorService vendorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchVendors() {
        // Arrange
        String userBranchCode = "ABC";
        List<VendorDTO> expectedVendors = Arrays.asList(
                new VendorDTO("V001", "Vendor 1"),
                new VendorDTO("V002", "Vendor 2")
        );

        when(vendorRepository.findVendorsByCriteria(userBranchCode.substring(0, 3)))
                .thenReturn(expectedVendors);

        // Act
        List<VendorDTO> actualVendors = vendorService.fetchVendors(userBranchCode);

        // Assert
        assertEquals(expectedVendors, actualVendors);
    }
}
