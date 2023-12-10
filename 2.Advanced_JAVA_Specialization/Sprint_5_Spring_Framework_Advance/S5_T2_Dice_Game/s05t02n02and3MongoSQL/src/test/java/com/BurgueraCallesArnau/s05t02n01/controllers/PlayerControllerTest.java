package com.BurgueraCallesArnau.s05t02n01.controllers;

import com.BurgueraCallesArnau.s05t02n01.controllers.rest.GameController;
import com.BurgueraCallesArnau.s05t02n01.controllers.rest.PlayerController;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.security.JwtService;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import com.BurgueraCallesArnau.s05t02n01.service.GameService;
import com.BurgueraCallesArnau.s05t02n01.service.PlayerService;
import com.BurgueraCallesArnau.s05t02n01.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.assertj.core.api.Assertions;

import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = PlayerController.class)
@AutoConfigureMockMvc(addFilters = false)//circumvent security
@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private PlayerService playerService;
    @MockBean
    private GameService gameService;
    @MockBean
    private JwtService jwtService;

    @InjectMocks
    private PlayerController playerController;

    @Autowired
    PlayerControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @Test
    @DisplayName("Update Player Name - Should return 200 OK with updated player")
    public void updatePlayerName_ShouldReturnOkWithUpdatedPlayer1() throws Exception {
        String newName = "newName";
        Player player = Player.builder()
                .id(new ObjectId("655c7adf06e4ae59f47979ca"))
                .name(newName)
                .build();
        given(playerService.updatePlayerName(player.getId(), newName)).willReturn(player);

        mockMvc.perform(put("/players/update/{id}", player.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.TEXT_PLAIN_VALUE)//indiferent si es plaintext o json
                        .content(/*objectMapper.writeValueAsString(*/newName/*)*/) //SI ES OBJECTE RETORNA
                        .characterEncoding("utf-8"))
                        .andDo(print())

                /*.andExpect(status().isOk())*/
                .andExpect(jsonPath("$.name").value(player.getName()));
    }

    @Test
    @DisplayName("Delete Player - Should return 200 OK with success message")
    public void deletePlayer_ShouldReturnOkWithSuccessMessage() throws Exception {
        ObjectId playerId = new ObjectId("655c7adf06e4ae59f47979ca");

        doNothing().when(playerService).deletePlayer(playerId);

        mockMvc.perform(delete("/players/delete/{id}", playerId))
                .andExpect(status().isOk())
                .andExpect(content().string(Constants.deletePlayerResponseBody));

        verify(playerService, times(1)).deletePlayer(playerId);
    }
}
