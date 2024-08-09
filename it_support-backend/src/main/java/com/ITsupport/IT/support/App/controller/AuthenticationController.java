package com.ITsupport.IT.support.App.controller;



import com.ITsupport.IT.support.App.DTO.AuthenticationRequest;
import com.ITsupport.IT.support.App.DTO.AuthenticationResponse;
import com.ITsupport.IT.support.App.DTO.RegisterRequest;
import com.ITsupport.IT.support.App.service.Imlp.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/Admin/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/registerAdmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.registerAdmin(request));
    }
    @PostMapping("/Admin/registerTechnicien")
    public ResponseEntity<AuthenticationResponse> registerTechnicien(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.registerTechnicien(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));

    }



}