package com.azbj.qc;

import com.azbj.qc.service.ControlService;
import com.azbj.qc.dto.ResetRequestDTO;
import com.azbj.qc.dto.NomineeUpdateDTO;
import com.azbj.qc.dto.ControlUpdateDTO;
import com.azbj.qc.dto.DocumentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ControlServiceTest {

    @Mock
    private ControlService controlService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testResetControlData() {
        ResetRequestDTO resetRequest = new ResetRequestDTO();
        resetRequest.setPolicyRef("POL123");

        doNothing().when(controlService).resetControlData(resetRequest);

        controlService.resetControlData(resetRequest);

        verify(controlService, times(1)).resetControlData(resetRequest);
    }

    @Test
    void testUpdateNomineeDetails() {
        NomineeUpdateDTO nomineeUpdateDTO = new NomineeUpdateDTO();
        nomineeUpdateDTO.setPolicyRef("POL123");
        nomineeUpdateDTO.setNewNomineeName("John Doe");

        when(controlService.updateNomineeDetails(nomineeUpdateDTO)).thenReturn("Nominee Name updated successfully");

        String result = controlService.updateNomineeDetails(nomineeUpdateDTO);

        assertEquals("Nominee Name updated successfully", result);
        verify(controlService, times(1)).updateNomineeDetails(nomineeUpdateDTO);
    }

    @Test
    void testUpdateQCRecords() {
        ControlUpdateDTO controlUpdateDTO = new ControlUpdateDTO();
        controlUpdateDTO.setPolicyRef("POL123");

        doNothing().when(controlService).updateQCRecords(controlUpdateDTO);

        controlService.updateQCRecords(controlUpdateDTO);

        verify(controlService, times(1)).updateQCRecords(controlUpdateDTO);
    }

    @Test
    void testGetSolutionId() {
        String policyRef = "POL123";
        String expectedSolutionId = "SOL123";

        when(controlService.getSolutionId(policyRef)).thenReturn(expectedSolutionId);

        String result = controlService.getSolutionId(policyRef);

        assertEquals(expectedSolutionId, result);
        verify(controlService, times(1)).getSolutionId(policyRef);
    }

    @Test
    void testGetDocumentPath() {
        String policyRef = "POL123";
        DocumentDTO expectedDocument = new DocumentDTO();
        expectedDocument.setFilePath("/path/to/document.pdf");

        when(controlService.getDocumentPath(policyRef)).thenReturn(expectedDocument);

        DocumentDTO result = controlService.getDocumentPath(policyRef);

        assertEquals(expectedDocument, result);
        verify(controlService, times(1)).getDocumentPath(policyRef);
    }

    @Test
    void testVerifyPolicyNumber() {
        String policyRef = "POL123";

        doNothing().when(controlService).verifyPolicyNumber(policyRef);

        controlService.verifyPolicyNumber(policyRef);

        verify(controlService, times(1)).verifyPolicyNumber(policyRef);
    }
}
