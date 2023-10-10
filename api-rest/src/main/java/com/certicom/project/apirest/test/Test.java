package com.certicom.project.apirest.test;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test" , produces = MediaType.APPLICATION_JSON_VALUE)
public class Test {

    @GetMapping
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok("Pio Pio");
    }
}
