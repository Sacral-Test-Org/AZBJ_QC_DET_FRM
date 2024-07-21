package com.azbj.qc;

import com.azbj.qc.service.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @InjectMocks
    private AuthenticationService authenticationService;

    @Mock
    private AuthenticationService mockAuthenticationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticate() {
        // Given
        String supervisorId = "SUP1234567";
        String password = "password123";
        String comments = "This is a test comment.";

        // When
        when(mockAuthenticationService.authenticate(supervisorId, password, comments)).thenReturn(true);
        boolean result = authenticationService.authenticate(supervisorId, password, comments);

        // Then
        assertTrue(result);
        verify(mockAuthenticationService, times(1)).authenticate(supervisorId, password, comments);
    }

    @Test
    public void testValidateCredentials() {
        // Given
        String supervisorId = "SUP1234567";
        String password = "password123";

        // When
        when(mockAuthenticationService.validateCredentials(supervisorId, password)).thenReturn(true);
        boolean result = authenticationService.validateCredentials(supervisorId, password);

        // Then
        assertTrue(result);
        verify(mockAuthenticationService, times(1)).validateCredentials(supervisorId, password);
    }
}
