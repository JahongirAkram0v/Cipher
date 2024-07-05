package com.example.cipher.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public ResponseEntity<String> home() {
        String text = "Hello my brother.<br>It is just demo cipher spring boot app<hr>";
        return new ResponseEntity<>(text, HttpStatus.OK);
    }
}
