package org.springboardfoundation.usersservice.configuration;

import lombok.RequiredArgsConstructor;
import org.springboardfoundation.common.dto.AuthenticationRequest;
import org.springboardfoundation.common.dto.AuthenticationResponse;
import org.springbordfoundation.db.respositories.UserRepositoy;
import org.springbordfoundation.db.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    @Autowired
    private UserDbService userDbService;

    private JwtTokenUtil jwtService;

    private final UserRepositoy repository;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMobileNumber(),
                        request.getPassword()
                )
        );

        var user = repository.findByMobileNumber(request.getMobileNumber())
                .orElseThrow();
        var jwtToken = jwtService.generateTokens(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
