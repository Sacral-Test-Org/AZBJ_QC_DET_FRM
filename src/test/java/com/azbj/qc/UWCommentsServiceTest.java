package com.azbj.qc;

import com.azbj.qc.service.UWCommentsService;
import com.azbj.qc.model.UWComment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UWCommentsServiceTest {

    @Mock
    private UWCommentsService uwCommentsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetComments() {
        String policyNumber = "POL123";
        String userProfile = "SUPERVISOR";

        List<UWComment> mockComments = Arrays.asList(
                new UWComment("user1", "2023-10-01", "Comment 1"),
                new UWComment("user2", "2023-10-02", "Comment 2")
        );

        when(uwCommentsService.getComments(policyNumber, userProfile)).thenReturn(mockComments);

        List<UWComment> comments = uwCommentsService.getComments(policyNumber, userProfile);

        assertEquals(2, comments.size());
        assertEquals("Comment 1", comments.get(0).getComment());
        assertEquals("Comment 2", comments.get(1).getComment());
    }

    @Test
    public void testUpdateComments() {
        // Assuming updateComments method exists in UWCommentsService
        // and it takes a list of UWComment objects and updates them.

        List<UWComment> commentsToUpdate = Arrays.asList(
                new UWComment("user1", "2023-10-01", "Updated Comment 1"),
                new UWComment("user2", "2023-10-02", "Updated Comment 2")
        );

        uwCommentsService.updateComments(commentsToUpdate);

        // Verify that the updateComments method was called with the correct parameters
        // This can be done using Mockito's verify method if needed.
    }
}
