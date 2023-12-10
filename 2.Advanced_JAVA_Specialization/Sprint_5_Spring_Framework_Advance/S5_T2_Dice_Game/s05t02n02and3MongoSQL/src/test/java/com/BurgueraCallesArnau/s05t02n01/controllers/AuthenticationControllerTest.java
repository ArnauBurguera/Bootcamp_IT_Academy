package com.BurgueraCallesArnau.s05t02n01.controllers;

import com.BurgueraCallesArnau.s05t02n01.controllers.rest.AuthenticationController;
import com.BurgueraCallesArnau.s05t02n01.controllers.rest.PlayerController;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationRequest;
import com.BurgueraCallesArnau.s05t02n01.security.AuthenticationResponse;
import com.BurgueraCallesArnau.s05t02n01.security.JwtService;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import com.BurgueraCallesArnau.s05t02n01.service.AuthenticationService;
import com.BurgueraCallesArnau.s05t02n01.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@WebMvcTest(controllers = AuthenticationControllerTest.class)
@AutoConfigureMockMvc(addFilters = false)//circumvent security*/
@ExtendWith(MockitoExtension.class)
public class AuthenticationControllerTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private /*final*/ MockMvc mockMvc;

    @Mock
    private AuthenticationService authenticationService;
    @Mock
    private PlayerService playerService;
    @MockBean
    private JwtService jwtService;

    @InjectMocks
    private AuthenticationController authenticationController;

    /*@Autowired
    AuthenticationControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;;
    }*/

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
    }


    @Test
    void testRegister() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest("Alex", "alex@gmail.com", "alexmore23");
        AuthenticationResponse expectedResponse = new AuthenticationResponse("expectedResponse");

        given(authenticationService.register(registerRequest)).willReturn(expectedResponse);

        mockMvc.perform(post("/auth/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("expectedResponse"));

        verify(authenticationService, times(1)).register(registerRequest);
        verifyNoMoreInteractions(authenticationService);
    }

    @Test
    void testAuthenticate() throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("john@example.com", "password");
        AuthenticationResponse expectedResponse = new AuthenticationResponse("expectedResponse");

        when(authenticationService.authenticate(authenticationRequest)).thenReturn(expectedResponse);

        mockMvc.perform(post("/auth/authenticate")
                        .content(objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("expectedValue"));

        verify(authenticationService, times(1)).authenticate(authenticationRequest);
        verifyNoMoreInteractions(authenticationService);
    }

}
