package com.example.wordlinetestapi.controller;

import com.example.wordlinetestapi.service.PerfectNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/perfect-number")
public class PerfectNumberController {

    private PerfectNumberService service;

    public PerfectNumberController(PerfectNumberService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<List<BigInteger>> getPerfectNumbers(@RequestBody List<BigInteger> numbers){
        List<BigInteger> response = service.getPerfectNumbers(numbers);
        return ResponseEntity.ok(response);
    }
}
