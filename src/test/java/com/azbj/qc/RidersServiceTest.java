package com.azbj.qc;

import com.azbj.qc.service.RidersService;
import com.azbj.qc.dto.RiderDTO;
import com.azbj.qc.model.Rider;
import com.azbj.qc.repository.RidersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RidersServiceTest {

    @InjectMocks
    private RidersService ridersService;

    @Mock
    private RidersRepository ridersRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCoverDetails() {
        RiderDTO riderDTO = new RiderDTO();
        riderDTO.setCoverCode("COVER123");
        riderDTO.setSumInsured(100000);
        riderDTO.setBenefitTerm(10);
        riderDTO.setPremiumTerm(5);

        Rider rider = new Rider();
        rider.setCoverCode("COVER123");
        rider.setSumInsured(100000);
        rider.setBenefitTerm(10);
        rider.setPremiumTerm(5);

        when(ridersRepository.save(any(Rider.class))).thenReturn(rider);

        Rider savedRider = ridersService.saveCoverDetails(riderDTO);

        assertNotNull(savedRider);
        assertEquals("COVER123", savedRider.getCoverCode());
        assertEquals(100000, savedRider.getSumInsured());
        assertEquals(10, savedRider.getBenefitTerm());
        assertEquals(5, savedRider.getPremiumTerm());
    }
}
