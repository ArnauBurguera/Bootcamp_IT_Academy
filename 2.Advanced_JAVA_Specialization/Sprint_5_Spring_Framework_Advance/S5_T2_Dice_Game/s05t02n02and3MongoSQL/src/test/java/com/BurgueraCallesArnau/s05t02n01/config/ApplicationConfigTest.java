package com.BurgueraCallesArnau.s05t02n01.config;

import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class ApplicationConfigTest {

    @Mock
    private PlayerRepository playerRepository;

    @Test
    void testUserDetailsService() {
        // Create an instance of ApplicationConfig and inject the mocked PlayerRepository
        ApplicationConfig applicationConfig = new ApplicationConfig(playerRepository);

        // Use Mockito's when to specify the behavior of the mock
        when(playerRepository.findByEmail("existing@example.com"))
                .thenReturn(Optional.of(/* create a Player entity here */));

        // Test the userDetailsService method
        UserDetailsService userDetailsService = applicationConfig.userDetailsService();

        // Assertions and further testing based on the behavior of the mocked objects
    }
}