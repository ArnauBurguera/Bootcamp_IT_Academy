package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationRequest;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationResponse;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PlayerRepository playerRepository;

    /*public AuthenticationResponse register(RegisterRequest request) {
        *//*var user = Player.builder
        return null;*//*
    }*/

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }
}
