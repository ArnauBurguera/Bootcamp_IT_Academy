package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.exceptions.PlayerNotFoundException;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Role;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationRequest;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationResponse;
import com.BurgueraCallesArnau.s05t02n01.security.JwtService;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {
    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PlayerService playerService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;


    @InjectMocks
    private AuthenticationService authenticationService;

    @DisplayName("Register - Should successfully register a player and return a valid JWT token")
    @Test
    void registerTest_ShouldReturnJwtToken() {
        RegisterRequest registerRequest = new RegisterRequest("John Doe", "john@example.com", "password");
        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encodedPassword");
        when(jwtService.generateToken(any(Player.class))).thenReturn("jwtToken");

        AuthenticationResponse response = authenticationService.register(registerRequest);

        Assertions.assertThat("jwtToken").isEqualTo(response.getToken());
        verify(playerService, times(1)).createPlayer(any(Player.class));
    }

    @DisplayName("Authenticate - Should successfully authenticate and return a valid JWT token")
    @Test
    void authenticateTest_ShouldReturnJwtToken() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("john@example.com", "password");
        Player mockPlayer = Player.builder().name("John Doe").email("john@example.com").password("encodedPassword").build();

        when(playerRepository.findByEmail(authenticationRequest.getEmail())).thenReturn(Optional.of(mockPlayer));
        when(jwtService.generateToken(any(Player.class))).thenReturn("jwtToken");

        AuthenticationResponse response = authenticationService.authenticate(authenticationRequest);

        Assertions.assertThat("jwtToken").isEqualTo(response.getToken());
    }

    @DisplayName("Authenticate - Should throw PlayerNotFoundException for invalid credentials")
    @Test
    void authenticateTest_ShouldThrowPlayerNotFoundException() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("nonexistent@example.com", "password");

        when(playerRepository.findByEmail(authenticationRequest.getEmail())).thenThrow(PlayerNotFoundException.class);

        Assertions.assertThatThrownBy(() -> authenticationService.authenticate(authenticationRequest))
                .isInstanceOf(PlayerNotFoundException.class);
    }
}
