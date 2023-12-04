package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
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
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {
    /*TODO checkPlayerName(Player player)
    TODO getPlayerGames(ObjectId playerId), calculateSuccessPercentage(ObjectId playerId)
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

    @DisplayName("Player Service Get All Players - Should return a list of all players")
    @Test
    public void getAllPlayersTest_ShouldReturnListOfPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = Player.builder().build();
        Player player2 = Player.builder().build();
        players.add(player1);
        players.add(player2);
        when(playerRepository.findAll()).thenReturn(players);

        List<Player> result = playerService.getAllPlayers();

        verify(playerRepository, times(1)).findAll();
        Assertions.assertThat((players)).isEqualTo(result);
    }

    @DisplayName("Player Service Get Player Games - Should return the list of player's games")
    @Test
    public void getPlayerGamesTest_ShouldReturnListOfPlayerGames() {
        Player player = Player.builder().build();
        Game game1 = Game.builder().build();
        Game game2 = Game.builder().build();
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        when(gameService.getGamesForPlayer(player.getId())).thenReturn(games);

        List<Game> result = playerService.getPlayerGames(player.getId());

        verify(gameService, times(1)).getGamesForPlayer(player.getId());
        Assertions.assertThat(games).isEqualTo(result);
    }
}
