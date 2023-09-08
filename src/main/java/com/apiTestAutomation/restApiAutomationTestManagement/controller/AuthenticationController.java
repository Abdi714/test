package com.apiTestAutomation.restApiAutomationTestManagement.controller;

import com.apiTestAutomation.restApiAutomationTestManagement.dao.request.SignUpRequest;
import com.apiTestAutomation.restApiAutomationTestManagement.dao.request.SigninRequest;
import com.apiTestAutomation.restApiAutomationTestManagement.dao.response.JwtAuthenticationResponse;
import com.apiTestAutomation.restApiAutomationTestManagement.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @PostMapping(path = "/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
