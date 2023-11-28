package com.BurgueraCallesArnau.s05t02n01.repository;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import org.bson.types.ObjectId;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;

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

    @Test
    public void findByPlayerIdTest_ShouldReturnListOfGamesBasedOnPlayerId(){
        Game game1 = Game.builder()
                .build();
        Game game2 = Game.builder()
                .build();
        Game game3 = Game.builder()
                .build();

        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);

        Player player = Player.builder()
                .id(new ObjectId("655c7adf06e4ae59f47979ca"))
                .build();

        player.addGame(game1);
        player.addGame(game2);
        player.addGame(game3);
        playerRepository.save(player);

        gameRepository.findByPlayerId(new ObjectId("655c7adf06e4ae59f47979ca"));




    }




}
