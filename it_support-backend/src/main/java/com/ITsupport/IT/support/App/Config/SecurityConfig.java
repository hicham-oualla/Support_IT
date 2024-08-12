package com.ITsupport.IT.support.App.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorize -> authorize
//                                .requestMatchers("/api/v1/auth/registerAdmin", "/api/v1/auth/authenticate").permitAll()
//                                .requestMatchers("/api/v1/auth/utilisateur/**","api/v1/auth/ticket/add","api/v1/auth/ticket/ticketByUser/"
//                                ,"api/v1/auth/panne/all").hasAuthority("USER")
//                                .requestMatchers("/api/v1/auth/Admin/**","api/v1/auth/panne").hasAuthority("ADMIN")
//                                .requestMatchers("/api/v1/auth/technicien/**","/api/v1/auth/ticket/ticketBytech/**").hasAuthority("TECHNICIEN")
//
//                                .anyRequest()
//                                .authenticated()
//                )
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                    .anyRequest().permitAll()
            )
            .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

    return http.build();
}

}