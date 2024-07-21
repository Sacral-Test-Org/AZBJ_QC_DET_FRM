package com.azbj.qc.controller;

import com.azbj.qc.service.AuthenticationService;
import com.azbj.qc.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody UserDTO userDTO) {
        boolean isAuthenticated = authenticationService.authenticate(userDTO.getSupervisorId(), userDTO.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Approved");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
