package com.BurgueraCallesArnau.s05t02n01.controllers.rest;

import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationRequest;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationResponse;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import com.BurgueraCallesArnau.s05t02n01.service.AuthenticationService;
import com.BurgueraCallesArnau.s05t02n01.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.AuthenticationControllerRequestMapping)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(Constants.register)
    @Operation(summary = Constants.registerSwaggerSummary, description = Constants.registerSwaggerDscr)
    public ResponseEntity<AuthenticationResponse> register(
            @Parameter(description = Constants.registerSwaggerParam, required = true)
            @RequestBody RegisterRequest request
    ){
        return  ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping(Constants.authenticate)
    @Operation(summary = Constants.authenticateSwaggerSummary, description = Constants.authenticateSwaggerDscr)
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Parameter(description = Constants.authenticateSwaggerParam, required = true)
            @RequestBody AuthenticationRequest request
    ){
        return  ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
