package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Role;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationRequest;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationResponse;
import com.BurgueraCallesArnau.s05t02n01.security.JwtService;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Player.builder()
                .name(request.getName())
                .email(request.getEmail())
                .registrationDate(Calendar.getInstance().getTime())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        playerService.createPlayer(user);
        var jwtToken =jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()
                )
        );
        var user = playerRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken =jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
