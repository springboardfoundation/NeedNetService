package org.springboardfoundation.usersservice.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springbordfoundation.db.respositories.UserRepositoy;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

import static org.hibernate.internal.util.StringHelper.isEmpty;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final UserRepositoy userRepo;
    final String userId;
    String username;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        username = (String) jwtTokenUtil.extractUsername(token);
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {


            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (!jwtTokenUtil.isTokenValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null,
                        userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        chain.doFilter(request, response);

//        // Get user identity and set it on the spring security context
//        UserDetails userDetails = userRepo
//                .findByUserIdentifier(jwtTokenUtil.extractUsername(token))
//                .orElse(null);
//
//        UsernamePasswordAuthenticationToken
//                authentication = new UsernamePasswordAuthenticationToken(
//                userDetails, null,
//                userDetails == null ?
//                        List.of() : userDetails.getAuthorities()
//        );
//
//        authentication.setDetails(
//                new WebAuthenticationDetailsSource().buildDetails(request)
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(request, response);
    }

}