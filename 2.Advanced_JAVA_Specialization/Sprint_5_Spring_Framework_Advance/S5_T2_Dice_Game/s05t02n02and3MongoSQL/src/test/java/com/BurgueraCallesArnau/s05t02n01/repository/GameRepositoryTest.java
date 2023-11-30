package com.BurgueraCallesArnau.s05t02n01.repository;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GameRepositoryTest {//TODO: findPlayer(id);

    private final GameRepository gameRepository;//Field injection is not best practice

    @Autowired
    public GameRepositoryTest(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @DisplayName("Game Repository Save - Should return a Saved Game")
    @Test
    public void saveTest_ShouldReturnSavedGame(){
        Game game = Game.builder()
                .dice1(3)
                .dice2(4)
                .won(true)
                .playerId(new ObjectId("655c7adf06e4ae59f47979ca"))
                .build();

        Game savedGame = gameRepository.save(game);
        Assertions.assertThat(savedGame).isNotNull();
        Assertions.assertThat(savedGame.getId()).isGreaterThan(0);
    }

    @DisplayName("Game Repository Delete All - Should delete all Games in repository")
    @Test
    public void deleteAllTest_ShouldDeleteAllGamesInRepository(){
        Game game = Game.builder()
                .dice1(3)
                .dice2(4)
                .won(true)
                .playerId(new ObjectId("655c7adf06e4ae59f47979ca"))
                .build();
        Game game2 = Game.builder()
                .build();

        gameRepository.save(game);
        gameRepository.save(game2);

        List<Game> gamesToDelete  = new ArrayList<>();
        gamesToDelete .add(game);
        gamesToDelete .add(game2);

        gameRepository.deleteAll(gamesToDelete );
        Assertions.assertThat(gameRepository.findAll()).isEmpty();
    }

    @DisplayName("Game Repository Find Game By Player Id - Should return a List of games based on PlayerId")
    @Test
    public void findGamesByPlayerIdTest_ShouldReturnListOfGamesBasedOnPlayerId(){
        ObjectId playerId = new ObjectId("655c7adf06e4ae59f47979ca");

        Game game1 = Game.builder()
                .playerId(playerId)
                .build();
        Game game2 = Game.builder()
                .playerId(playerId)
                .build();
        Game game3 = Game.builder()
                .playerId(playerId)
                .build();

        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);

        List<Game> gameList = gameRepository.findGamesByPlayerId(playerId);
        Assertions.assertThat(gameList).isNotNull();
        Assertions.assertThat(gameList).containsExactly(game1,game2,game3);
    }
}