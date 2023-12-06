package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {
    /*TODO checkPlayerName(Player player)
    TODO getPlayersRankedBySuccessPercentage(), getLoser(), getWinner()
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
                .id(new ObjectId("655c7adf06e4ae59f47979ca"))//need to add Ids manually 'cause mocks don't behave as repos would
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
        Player player = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).games(new ArrayList<>()).build();

        when(gameService.findPlayer(player.getId())).thenReturn(player);
        when(playerRepository.save(player)).thenReturn(player);

        playerService.updatePlayerName(player.getId(), newName);

        verify(playerRepository, times(1)).save(player);
        Assertions.assertThat(gameService.findPlayer(player.getId()).getName()).isEqualTo(newName);
    }

    @DisplayName("Player Service Get All Players - Should return a list of all players")
    @Test
    public void getAllPlayersTest_ShouldReturnListOfPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();
        Player player2 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979cb")).build();
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
        Player player = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();
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

    @DisplayName("Player Service Calculate Success Percentage - Should calculate success percentage")
    @Test
    public void calculateSuccessPercentageTest_ShouldCalculateSuccessPercentage() {
        Player player = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();
        System.out.println(player.getId());
        List<Game> games = new ArrayList<>();
        Game game1 = Game.builder().won(true).build();
        Game game2 = Game.builder().won(false).build();
        games.add(game1);
        games.add(game2);
        final double  PERCENTAGE = 50.0d;
        when(gameService.getGamesForPlayer(player.getId())).thenReturn(games);

        double result = playerService.calculateSuccessPercentage(player.getId());

        verify(gameService, times(1)).getGamesForPlayer(player.getId());
        Assertions.assertThat(PERCENTAGE).isEqualTo(result);
    }

    @DisplayName("Player Service Calculate Average Success Percentage - Should calculate average success percentage")
    @Test
    public void calculateAverageSuccessPercentageTest_ShouldCalculateAverageSuccessPercentage() {
        PlayerService spy = Mockito.spy(playerService);//To partially stub methods in this class
        Player player1 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();
        Player player2 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979cb")).build();
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        final double  PERCENTAGE = 50.0d;
        when(spy.getAllPlayers()).thenReturn(players);//stub the methods that have to be mocked in class
        when(spy.calculateSuccessPercentage(player1.getId())).thenReturn(100.0d);
        when(spy.calculateSuccessPercentage(player2.getId())).thenReturn(0.0d);

        double result = spy.calculateAverageSuccessPercentage();

        verify(playerRepository, times(1)).findAll();
        Assertions.assertThat(PERCENTAGE).isEqualTo(result);
    }

    @DisplayName("Player Service Get Players Ranked By Success Percentage - Should return players ranked by success percentage")
    @Test
    public void getPlayersRankedBySuccessPercentageTest_ShouldReturnPlayersRankedBySuccessPercentage() {
        PlayerService spy = Mockito.spy(playerService);//To partially stub methods in this class
        Player player1 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();
        Player player2 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979cb")).build();
        Player player3 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979cc")).build();
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        when(playerRepository.findAll()).thenReturn(players);
        when(spy.calculateSuccessPercentage(player1.getId())).thenReturn(100.0d);
        when(spy.calculateSuccessPercentage(player2.getId())).thenReturn(0.0d);
        when(spy.calculateSuccessPercentage(player3.getId())).thenReturn(50.0d);

        List<Player> result = spy.getPlayersRankedBySuccessPercentage();
        System.out.println(result.toString());

        verify(playerRepository, times(1)).findAll();
        Assertions.assertThat(result).containsExactly(player1,player3,player2);
    }

    @DisplayName("Player Service Get Loser - Should return the player with the lowest success percentage")
    @Test
    public void getLoserTest_ShouldReturnPlayerWithLowestSuccessPercentage() {
        PlayerService spy = Mockito.spy(playerService);//To partially stub methods in this class
        Player player1 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();
        Player player2 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979cb")).build();
        Player player3 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979cc")).build();
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        when(playerRepository.findAll()).thenReturn(players);
        when(spy.calculateSuccessPercentage(player1.getId())).thenReturn(100.0d);
        when(spy.calculateSuccessPercentage(player2.getId())).thenReturn(0.0d);
        when(spy.calculateSuccessPercentage(player3.getId())).thenReturn(50.0d);

        Player loser = spy.getLoser();

        verify(playerRepository, times(1)).findAll();
        Assertions.assertThat(loser).isSameAs(player2);
    }

    @DisplayName("Player Service Get Winner - Should return the player with the highest success percentage")
    @Test
    public void getWinnerTest_ShouldReturnPlayerWithHighestSuccessPercentage() {
        PlayerService spy = Mockito.spy(playerService);//To partially stub methods in this class
        Player player1 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979ca")).build();
        Player player2 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979cb")).build();
        Player player3 = Player.builder().id(new ObjectId("655c7adf06e4ae59f47979cc")).build();
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        when(playerRepository.findAll()).thenReturn(players);
        when(spy.calculateSuccessPercentage(player1.getId())).thenReturn(100.0d);
        when(spy.calculateSuccessPercentage(player2.getId())).thenReturn(0.0d);
        when(spy.calculateSuccessPercentage(player3.getId())).thenReturn(50.0d);

        Player winner = spy.getWinner();

        verify(playerRepository, times(1)).findAll();
        Assertions.assertThat(winner).isSameAs(player1);
    }
}
