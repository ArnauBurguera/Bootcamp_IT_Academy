package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.repository.GameRepository;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    //TODO findPlayer(id), getGamesForPlayer(playerId)
    //TODO  deleteGamesFromRepo(ObjectId playerId)

    @Mock
    private GameRepository gameRepository;
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private GameService gameService;

    @BeforeEach
    void setUp(){
        gameRepository.deleteAll();
        playerRepository.deleteAll();
    }

    @DisplayName("Game Service Play Game - Should return a Game Object")
    @Test
    public void PlayGameTest_ShouldReturnGameObject() {
        Player player = Player.builder().games(new ArrayList<>()).build();
        when(playerRepository.findById(player.getId())).thenReturn(java.util.Optional.of(player));

        Game game = gameService.playGame(player.getId());

        verify(gameRepository, times(1)).save(any(Game.class));
        verify(playerRepository, times(1)).save(any(Player.class));
        Assertions.assertThat(player.getGames().contains(game)).isTrue();
        Assertions.assertThat(player.getGames().size()).isEqualTo(1);
    }

    @DisplayName("Game Service Delete Games For Player - Should delete games and update player")
    @Test
    public void deleteGamesForPlayerTest_ShouldDeleteGamesAndUpdatePlayer() {
        Player player = Player.builder().games(new ArrayList<>()).build();
        Game game1 = Game.builder().build();
        Game game2 = Game.builder().build();
        player.addGame(game1);
        player.addGame(game2);
        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));

        gameService.deleteGamesForPlayer(player.getId());

        verify(gameRepository, times(1)).deleteAll(anyList());
        verify(playerRepository, times(1)).save(any(Player.class));
        Assertions.assertThat(player.getGames().isEmpty()).isTrue();
    }

    @DisplayName("Game Service Delete Games From Repo - Should delete games from Game repository")
    @Test
    public void deleteGamesFromRepoTest_ShouldDeleteGamesFromGameRepository() {
        Player player = Player.builder().games(new ArrayList<>()).build();
        Game game1 = Game.builder().build();
        Game game2 = Game.builder().build();
        player.addGame(game1);
        player.addGame(game2);
        when(gameRepository.findGamesByPlayerId(player.getId())).thenReturn(player.getGames());

        gameService.deleteGamesFromRepo(player.getId());

        verify(gameRepository, times(1)).deleteAll(player.getGames());
        Assertions.assertThat(gameRepository.findAll().isEmpty()).isTrue();
    }
}
