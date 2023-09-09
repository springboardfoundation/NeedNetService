package org.springboardfoundation.usersservice.controller;

import lombok.RequiredArgsConstructor;
import org.springboardfoundation.common.dto.AuthenticationRequest;
import org.springboardfoundation.common.dto.AuthenticationResponse;
import org.springboardfoundation.usersservice.configuration.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("/login")
        public ResponseEntity<AuthenticationResponse> login (
                @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
