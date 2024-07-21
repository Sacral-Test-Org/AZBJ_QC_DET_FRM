package com.azbj.qc.controller;

import com.azbj.qc.dto.PolicyDTO;
import com.azbj.qc.service.PolicySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policy")
public class PolicySearchController {

    @Autowired
    private PolicySearchService policySearchService;

    @GetMapping("/search/{policyRefNumber}")
    public ResponseEntity<PolicyDTO> searchPolicy(@PathVariable String policyRefNumber) {
        try {
            PolicyDTO policyDTO = policySearchService.searchPolicy(policyRefNumber);
            if (policyDTO == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(policyDTO, HttpStatus.OK);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    public ResponseEntity<String> handleException(Exception exception) {
        return new ResponseEntity<>("An error occurred: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
