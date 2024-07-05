package com.example.cipher.controller;

import com.example.cipher.service.CipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CipherController {

    private final CipherService service;

    @Autowired
    public CipherController(CipherService service) {
        this.service = service;
    }

    @GetMapping("/code")
    public ResponseEntity<String> makeCode(@RequestParam String text) {
        return new ResponseEntity<>(service.makeCode(text), HttpStatus.OK);
    }

    @GetMapping("/decode")
    public ResponseEntity<String> makeDecode(@RequestParam String text) {
        return new ResponseEntity<>(service.makeDecode(text), HttpStatus.OK);
    }
}
