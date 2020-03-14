package com.bnpparibas.hackathon.employee.api.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class EchoController {

    @GetMapping("/echo")
    public ResponseEntity<LocalDateTime> echo() {
        return ResponseEntity.of(
                Optional.of(
                        LocalDateTime.now()
                )
        );
    }

}
