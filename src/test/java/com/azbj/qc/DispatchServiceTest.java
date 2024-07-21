package com.azbj.qc;

import com.azbj.qc.service.DispatchService;
import com.azbj.qc.dto.DispatchDTO;
import com.azbj.qc.model.Dispatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DispatchServiceTest {

    @Mock
    private DispatchService dispatchService;

    @InjectMocks
    private DispatchServiceTest dispatchServiceTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveDispatchDetails() {
        DispatchDTO dispatchDTO = new DispatchDTO();
        dispatchDTO.setShipNo("SHIP123");
        dispatchDTO.setAwbNo("AWB123");
        dispatchDTO.setDelType("I");
        dispatchDTO.setVendor("Vendor1");
        dispatchDTO.setDesType("CUST");
        dispatchDTO.setPickReqNo("PICK123");
        dispatchDTO.setWt(10.5);
        dispatchDTO.setGm("Grm");

        Dispatch dispatch = new Dispatch();
        dispatch.setShipNo("SHIP123");
        dispatch.setAwbNo("AWB123");
        dispatch.setDelType("I");
        dispatch.setVendor("Vendor1");
        dispatch.setDesType("CUST");
        dispatch.setPickReqNo("PICK123");
        dispatch.setWt(10.5);
        dispatch.setGm("Grm");

        when(dispatchService.saveDispatchDetails(dispatchDTO)).thenReturn(dispatch);

        Dispatch result = dispatchService.saveDispatchDetails(dispatchDTO);

        assertNotNull(result);
        assertEquals("SHIP123", result.getShipNo());
        assertEquals("AWB123", result.getAwbNo());
        assertEquals("I", result.getDelType());
        assertEquals("Vendor1", result.getVendor());
        assertEquals("CUST", result.getDesType());
        assertEquals("PICK123", result.getPickReqNo());
        assertEquals(10.5, result.getWt());
        assertEquals("Grm", result.getGm());
    }

    @Test
    public void testGetDispatchDetails() {
        // Assuming getDispatchDetails method exists in DispatchService
        DispatchDTO dispatchDTO = new DispatchDTO();
        dispatchDTO.setShipNo("SHIP123");

        Dispatch dispatch = new Dispatch();
        dispatch.setShipNo("SHIP123");

        when(dispatchService.getDispatchDetails("SHIP123")).thenReturn(dispatch);

        Dispatch result = dispatchService.getDispatchDetails("SHIP123");

        assertNotNull(result);
        assertEquals("SHIP123", result.getShipNo());
    }

    @Test
    public void testClearDispatchDetails() {
        // Assuming clearDispatchDetails method exists in DispatchService
        doNothing().when(dispatchService).clearDispatchDetails();

        dispatchService.clearDispatchDetails();

        verify(dispatchService, times(1)).clearDispatchDetails();
    }
}
