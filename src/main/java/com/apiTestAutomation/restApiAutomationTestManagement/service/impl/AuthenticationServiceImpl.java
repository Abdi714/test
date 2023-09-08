package com.apiTestAutomation.restApiAutomationTestManagement.service.impl;

import com.apiTestAutomation.restApiAutomationTestManagement.dao.request.SignUpRequest;
import com.apiTestAutomation.restApiAutomationTestManagement.dao.request.SigninRequest;
import com.apiTestAutomation.restApiAutomationTestManagement.dao.response.JwtAuthenticationResponse;

import com.apiTestAutomation.restApiAutomationTestManagement.entities.Role;
import com.apiTestAutomation.restApiAutomationTestManagement.entities.RoleType;
import com.apiTestAutomation.restApiAutomationTestManagement.entities.User;
import com.apiTestAutomation.restApiAutomationTestManagement.repository.UserRepository;
import com.apiTestAutomation.restApiAutomationTestManagement.service.AuthenticationService;
import com.apiTestAutomation.restApiAutomationTestManagement.service.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private  JwtService jwtService;
    private  AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setFirstName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role userRole = new Role();
        userRole.setLabel(RoleType.USER);
        user.setRole(userRole);
        userRepository.save(user);

        String jwt = jwtService.generateToken(user);
        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user= userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        String jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;
    }
}
