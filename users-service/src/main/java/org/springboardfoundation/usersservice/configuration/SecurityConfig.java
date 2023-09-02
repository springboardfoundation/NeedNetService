package org.springboardfoundation.usersservice.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Autowired
   private final JwtTokenFilter jwtTokenFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //.formLogin(AbstractHttpConfigurer::disable)
                //.exceptionHandling(h -> h.authenticationEntryPoint(unauthorizedHandler))
                .securityMatcher("/**")
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                );

        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}