package com.BurgueraCallesArnau.s05t02n01.controllers;

import com.BurgueraCallesArnau.s05t02n01.controllers.rest.GameController;
import com.BurgueraCallesArnau.s05t02n01.controllers.rest.PlayerController;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Role;
import com.BurgueraCallesArnau.s05t02n01.security.JwtService;
import com.BurgueraCallesArnau.s05t02n01.security.RegisterRequest;
import com.BurgueraCallesArnau.s05t02n01.service.GameService;
import com.BurgueraCallesArnau.s05t02n01.service.PlayerService;
import com.BurgueraCallesArnau.s05t02n01.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.*;
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    private Player player;
    private Player player2;
    private final ObjectId PLAYERID;
    private List<Game> games;

    @Autowired
    PlayerControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.PLAYERID = new ObjectId("655c7adf06e4ae59f47979ca");
    }

    @BeforeEach
    public void setUp(){

        player = Player.builder()
                .id(PLAYERID)
                .name("Alex")
                .role(Role.USER)//Has problems if not assigned
                .build();
        player2 = Player.builder()
                .id(new ObjectId("655c7adf06e4ae59f47979cb"))
                .name("Alexa")
                .role(Role.USER)//Has problems if not assigned
                .build();
        games = Arrays.asList(
                Game.builder().playerId(PLAYERID).won(true).build(),
                Game.builder().playerId(PLAYERID).won(true).build(),
                Game.builder().playerId(PLAYERID).won(false).build(),
                Game.builder().playerId(PLAYERID).won(false).build()
        );
    }

    @Test
    @DisplayName("Update Player Name - Should return 200 OK with updated player")
    public void updatePlayerName_ShouldReturnOkWithUpdatedPlayer1() throws Exception {
        String newName = "newName";
        Player updatedplayer = this.player;
        updatedplayer.setName(newName);
        given(playerService.updatePlayerName(PLAYERID, newName)).willReturn(updatedplayer);

        mockMvc.perform(put("/players/update/{id}", PLAYERID, newName)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newName)
                        .characterEncoding("utf-8"))
                        .andDo(print())

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(newName));
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

    @Test
    @DisplayName("Get All Players - Should return 200 OK with a list of players")
    public void getAllPlayers_ShouldReturnOkWithListOfPlayers() throws Exception {
        List<Player> players = Arrays.asList(this.player, this.player2);
        given(playerService.getAllPlayers()).willReturn(players);

        mockMvc.perform(get("/players/getAll")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(players.size()))
                .andExpect(jsonPath("$[0].name").value(players.get(0).getName()))
                .andExpect(jsonPath("$[0].role").value(players.get(0).getRole().toString()))
                .andExpect(jsonPath("$[1].name").value(players.get(1).getName()))
                .andExpect(jsonPath("$[1].role").value(players.get(1).getRole().toString()));
    }

    @Test
    @DisplayName("Get Player Games - Should return 200 OK with player games")
    public void getPlayerGames_ShouldReturnOkWithPlayerGames() throws Exception {
        given(playerService.getPlayerGames(PLAYERID)).willReturn(this.games);

        mockMvc.perform(get("/players/{id}/games", PLAYERID)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(games.size()))
                .andExpect(jsonPath("$[0].won").value(true))
                .andExpect(jsonPath("$[1].won").value(true))
                .andExpect(jsonPath("$[2].won").value(false));
    }

    @Test
    @DisplayName("Calculate Success Percentage - Should return 200 OK with success percentage")
    public void calculateSuccessPercentage_ShouldReturnOkWithSuccessPercentage() throws Exception {
        double successPercentage = 50.0;
        given(playerService.calculateSuccessPercentage(PLAYERID)).willReturn(successPercentage);

        mockMvc.perform(get("/players/{id}/successPercentage", PLAYERID)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(successPercentage));

        verify(playerService, times(1)).calculateSuccessPercentage(PLAYERID);
    }

    @Test
    @DisplayName("Calculate Average Success Percentage - Should return 200 OK with calculated percentage")
    public void calculateAverageSuccessPercentage_ShouldReturnOkWithCalculatedPercentage() throws Exception {
        double averageSuccessPercentage = 75.0;
        given(playerService.calculateAverageSuccessPercentage()).willReturn(averageSuccessPercentage);

        mockMvc.perform(get("/players/averageSuccess")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(averageSuccessPercentage));

        verify(playerService, times(1)).calculateAverageSuccessPercentage();
    }
}
