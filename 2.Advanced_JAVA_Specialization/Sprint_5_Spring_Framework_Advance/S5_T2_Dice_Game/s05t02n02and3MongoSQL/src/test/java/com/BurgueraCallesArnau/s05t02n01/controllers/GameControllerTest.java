package com.BurgueraCallesArnau.s05t02n01.controllers;

import com.BurgueraCallesArnau.s05t02n01.controllers.rest.GameController;
import com.BurgueraCallesArnau.s05t02n01.exceptions.PlayerNotFoundException;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.security.JwtService;
import com.BurgueraCallesArnau.s05t02n01.service.GameService;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GameController.class)
@AutoConfigureMockMvc(addFilters = false)//circumvent security
@ExtendWith(MockitoExtension.class)
class GameControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private GameService gameService;
    @MockBean
    private JwtService jwtService;

    @InjectMocks
    private GameController gameController;

    @Autowired
    GameControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }


    @Test
    @DisplayName("Play Game - Should return 201 Created with a Game Object")
    public void playGameTest_ShouldReturnCreatedWithGameObject() throws Exception {

        Player player = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();
        Game game = Game.builder().build();

        given(gameService.playGame(player.getId())).willReturn(game);
        mockMvc.perform(post("/players/{playerId}/games/play", player.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(game)))

                .andExpect(status().isCreated());

        given(gameService.playGame(player.getId())).willThrow(PlayerNotFoundException.class);
        mockMvc.perform(post("/players/{playerId}/games/play", player.getId()))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Delete Games For Player - Should return 200 OK with success message")
    public void deleteGamesForPlayerTest_ShouldReturnOkWithSuccessMessage() throws Exception {
        Player player = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();

        doNothing().when(gameService).deleteGamesForPlayer(player.getId());
        mockMvc.perform(delete("/players/{playerId}/games/delete", player.getId()))
                .andExpect(status().isOk());
    }

   /* @Test
    @DisplayName("Delete Games For Player - Should throw PlayerNotFoundException when player not found")
    public void deleteGamesForPlayerTest_ShouldThrowPlayerNotFoundException() throws Exception {

        given(gameService.deleteGamesForPlayer(new ObjectId("655c7adf06e4ae59f47979ca"))).willThrow(PlayerNotFoundException.class);
        mockMvc.perform(delete("/players/{playerId}/games", new ObjectId("655c7adf06e4ae59f47979ca")))
                .andExpect(status().isNotFound());
    }*/

}
