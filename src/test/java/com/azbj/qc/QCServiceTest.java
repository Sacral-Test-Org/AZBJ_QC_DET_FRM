package com.azbj.qc;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.azbj.qc.service.QCService;
import com.azbj.qc.model.QCRecord;
import com.azbj.qc.repository.QCRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class QCServiceTest {

    @Mock
    private QCRepository qcRepository;

    @InjectMocks
    private QCService qcService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUpdateRecords() {
        // Arrange
        QCRecord record1 = new QCRecord("Y", 10);
        QCRecord record2 = new QCRecord("N", 10);
        QCRecord record3 = new QCRecord("Y", 5);
        List<QCRecord> records = Arrays.asList(record1, record2, record3);

        when(qcRepository.findAll()).thenReturn(records);

        // Act
        qcService.updateRecords();

        // Assert
        assertEquals("N", record1.getCi());
        assertEquals("N", record2.getCi()); // Should remain unchanged
        assertEquals("Y", record3.getCi()); // Should remain unchanged

        verify(qcRepository, times(1)).saveAll(records);
    }
}
