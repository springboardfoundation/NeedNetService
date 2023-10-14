package org.springboardfoundation.security;

import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springboardfoundation.common.dto.authentication.AuthenticationRequest;
import org.springboardfoundation.common.dto.authentication.AuthenticationResponse;
import org.springbordfoundation.db.respositories.UserRepository;
import org.springbordfoundation.db.service.UserDbService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    //private final UserDbService userDbService;
    private final JwtTokenUtil jwtService;
    //private final UserRepository repository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMobileNumber(),
                        request.getPassword()
                )
        );

//        var user = repository.findByMobileNumber(request.getMobileNumber())
//                .orElseThrow();
        var user = Mockito.mock(UserDetails.class);
        var jwtToken = jwtService.generateTokens(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
