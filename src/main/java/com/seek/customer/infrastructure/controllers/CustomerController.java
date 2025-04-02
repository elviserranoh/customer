package com.seek.customer.infrastructure.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(path="/")
class CustomerController {

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body("All customers");
    }

    public ResponseEntity<?> get() {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> create() {
        return ResponseEntity.created(URI.create("/user")).build();
    }

}