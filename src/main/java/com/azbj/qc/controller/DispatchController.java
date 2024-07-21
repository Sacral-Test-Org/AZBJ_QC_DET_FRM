package com.azbj.qc.controller;

import com.azbj.qc.dto.DispatchDTO;
import com.azbj.qc.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    @PostMapping("/save")
    public ResponseEntity<Dispatch> saveDispatchDetails(@RequestBody DispatchDTO dispatchDTO) {
        Dispatch dispatch = dispatchService.saveDispatchDetails(dispatchDTO);
        return ResponseEntity.ok(dispatch);
    }

    @PostMapping("/saveShipment")
    public ResponseEntity<String> saveShipmentDetails(@RequestBody DispatchDTO dispatchDTO) {
        String response = dispatchService.saveShipmentDetails(dispatchDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/details/{contractId}")
    public ResponseEntity<DispatchDTO> getDispatchDetails(@PathVariable String contractId) {
        DispatchDTO dispatchDTO = dispatchService.getDispatchDetails(contractId);
        return ResponseEntity.ok(dispatchDTO);
    }

    @PostMapping("/clear")
    public ResponseEntity<Void> clearDispatchDetails() {
        dispatchService.clearDispatchDetails();
        return ResponseEntity.noContent().build();
    }
}
