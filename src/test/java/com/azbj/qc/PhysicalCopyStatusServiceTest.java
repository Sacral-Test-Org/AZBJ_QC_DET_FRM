package com.azbj.qc;

import com.azbj.qc.service.PhysicalCopyStatusService;
import com.azbj.qc.dto.PhysicalCopyStatusDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PhysicalCopyStatusServiceTest {

    @Mock
    private PhysicalCopyStatusService physicalCopyStatusService;

    @InjectMocks
    private PhysicalCopyStatusServiceTest physicalCopyStatusServiceTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUpdatePhysicalCopyStatus() {
        PhysicalCopyStatusDTO validDto = new PhysicalCopyStatusDTO();
        validDto.setPolicyNo("12345");
        validDto.setPhysicalCopyStatus("Y");

        PhysicalCopyStatusDTO invalidDto = new PhysicalCopyStatusDTO();
        invalidDto.setPolicyNo("12345");
        invalidDto.setPhysicalCopyStatus("Invalid");

        when(physicalCopyStatusService.updatePhysicalCopyStatus(validDto)).thenReturn(true);
        when(physicalCopyStatusService.updatePhysicalCopyStatus(invalidDto)).thenReturn(false);

        boolean validResult = physicalCopyStatusService.updatePhysicalCopyStatus(validDto);
        boolean invalidResult = physicalCopyStatusService.updatePhysicalCopyStatus(invalidDto);

        assertTrue(validResult, "The update should be successful for valid input.");
        assertFalse(invalidResult, "The update should fail for invalid input.");

        verify(physicalCopyStatusService, times(1)).updatePhysicalCopyStatus(validDto);
        verify(physicalCopyStatusService, times(1)).updatePhysicalCopyStatus(invalidDto);
    }
}
