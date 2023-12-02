package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.repository.GameRepository;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    //TODO findPlayer(id), getGamesForPlayer(playerId)
    //TODO rollDice(ObjectId playerId), deleteGamesForPlayer(ObjectId playerId), deleteGamesFromRepo(ObjectId playerId)

    @Mock
    private GameRepository gameRepository;
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private GameService gameService;

    @Test
    public void testPlayGame() {
        Player player = Player.builder().games(new ArrayList<>()).build();
        when(playerRepository.findById(player.getId())).thenReturn(java.util.Optional.of(player));

        Game game = gameService.playGame(player.getId());

        verify(gameRepository, times(1)).save(any(Game.class));
        verify(playerRepository, times(1)).save(any(Player.class));
        Assertions.assertThat(player.getGames().contains(game)).isTrue();
        Assertions.assertThat(player.getGames().size()).isEqualTo(1);
    }
}
