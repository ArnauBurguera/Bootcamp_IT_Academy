package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {
    /*TODO checkPlayerName(Player player),updatePlayerName(ObjectId id, String name)
    TODO getAllPlayers(), getPlayerGames(ObjectId playerId), calculateSuccessPercentage(ObjectId playerId)
    TODO calculateAverageSuccessPercentage(), getPlayersRankedBySuccessPercentage(), getLoser(), getWinner()
    TODO deletePlayer(ObjectId playerId)
     */

    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private GameService gameService;

    @InjectMocks
    private PlayerService playerService;

    @BeforeEach
    void setUp(){
        playerRepository.deleteAll();
    }

    @DisplayName("Player Service Create Player - Should save player with default name")
    @Test
    public void createPlayerTest_ShouldSavePlayerWithDefaultName() {
        Player player = Player.builder()
                .name("Juanjo fa Kockey")
                .games(new ArrayList<>())
                .build();

        playerService.createPlayer(player);

        verify(playerRepository, times(1)).save(player);
    }

    @DisplayName("Player Service Update Player Name - Should update player name")
    @Test
    public void updatePlayerNameTest_ShouldUpdatePlayerName() {
        String newName = "NewName";
        Player player = Player.builder().games(new ArrayList<>()).build();

        when(gameService.findPlayer(player.getId())).thenReturn(player);
        when(playerRepository.save(player)).thenReturn(player);

        Player updatedPlayer = playerService.updatePlayerName(player.getId(), newName);

        verify(playerRepository, times(1)).save(player);
        Assertions.assertThat(gameService.findPlayer(player.getId()).getName()).isEqualTo(newName);
    }
}
