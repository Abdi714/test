package com.apiTestAutomation.restApiAutomationTestManagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthorizationController {
    @GetMapping(path = "signin")
    public ResponseEntity<String> sayHello() {

        return ResponseEntity.ok("Here is your resource");
    }
}
