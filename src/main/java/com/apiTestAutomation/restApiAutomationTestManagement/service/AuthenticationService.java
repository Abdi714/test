package com.apiTestAutomation.restApiAutomationTestManagement.service;

import com.apiTestAutomation.restApiAutomationTestManagement.dao.request.SignUpRequest;
import com.apiTestAutomation.restApiAutomationTestManagement.dao.request.SigninRequest;
import com.apiTestAutomation.restApiAutomationTestManagement.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SigninRequest request);

}
