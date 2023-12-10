package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Role;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationResponse;
import com.BurgueraCallesArnau.s05t02n01.security.JwtService;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Calendar;

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

    @Test
    void register_Success() {
        RegisterRequest registerRequest = new RegisterRequest("John Doe", "john@example.com", "password");
        Player expectedPlayer = Player.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .registrationDate(Calendar.getInstance().getTime())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .games(new ArrayList<>())
                .role(Role.USER)
                .build();

        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn(null);
        /*when(playerRepository.save(any(Player.class))).thenReturn(expectedPlayer);*/
        when(jwtService.generateToken(any(Player.class))).thenReturn("jwtToken");

        AuthenticationResponse response = authenticationService.register(registerRequest);

        Assertions.assertThat("jwtToken").isEqualTo(response.getToken());
        verify(playerService, times(1)).createPlayer(expectedPlayer);
    }

   /* @Test
    void authenticate_Success() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("john@example.com", "password");
        Player mockPlayer = Player.builder().name("John Doe").email("john@example.com").password("encodedPassword").build();

        when(playerRepository.findByEmail(authenticationRequest.getEmail())).thenReturn(Optional.of(mockPlayer));
        when(jwtService.generateToken(any(Player.class))).thenReturn("jwtToken");

        AuthenticationResponse response = authenticationService.authenticate(authenticationRequest);

        assertEquals("jwtToken", response.getToken());
    }

    @Test
    void authenticate_InvalidCredentials() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("nonexistent@example.com", "password");

        when(playerRepository.findByEmail(authenticationRequest.getEmail())).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> authenticationService.authenticate(authenticationRequest));
    }*/
}
