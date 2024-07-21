package com.azbj.qc.controller;

import com.azbj.qc.service.UWCommentsService;
import com.azbj.qc.dto.UWCommentDTO;
import com.azbj.qc.dto.RICODetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UWCommentsController {

    @Autowired
    private UWCommentsService uwCommentsService;

    @GetMapping("/comments")
    public ResponseEntity<List<UWCommentDTO>> getComments(@RequestParam String policyRef, @RequestParam String userId) {
        List<UWCommentDTO> comments = uwCommentsService.getComments(policyRef, userId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/rico-details")
    public ResponseEntity<List<RICODetailDTO>> getRICODetails(@RequestParam String policyRef) {
        List<RICODetailDTO> ricoDetails = uwCommentsService.getRICODetails(policyRef);
        return ResponseEntity.ok(ricoDetails);
    }

    @PostMapping("/comments")
    public ResponseEntity<Void> updateComments(@RequestBody List<UWCommentDTO> comments) {
        uwCommentsService.updateComments(comments);
        return ResponseEntity.ok().build();
    }
}
