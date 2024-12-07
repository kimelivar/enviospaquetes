package com.example.envios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracking")
public class EnviosController {
    private final AfterShipService afterShipService;

    public EnviosController(AfterShipService afterShipService) {
        this.afterShipService = afterShipService;
    }

    @GetMapping("/{carrierSlug}/{trackingId}")
    public ResponseEntity<String> trackPackage(@PathVariable String carrierSlug, @PathVariable String trackingId) {
        try {
            String result = afterShipService.getTrackingInfo(carrierSlug, trackingId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
}


