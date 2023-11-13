package com.BurgueraCallesArnau.s05t02n01.controllers.rest;

import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationRequest;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationResponse;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import com.BurgueraCallesArnau.s05t02n01.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return  ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return  ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
