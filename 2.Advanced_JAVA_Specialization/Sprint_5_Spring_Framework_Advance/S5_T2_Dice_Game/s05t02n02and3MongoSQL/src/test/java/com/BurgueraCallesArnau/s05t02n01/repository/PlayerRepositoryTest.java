package com.BurgueraCallesArnau.s05t02n01.repository;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

@DataMongoTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerRepositoryTest {
    //TODO: findAll, delete, findByEmail(String email), findById(playerId)

    private final PlayerRepository playerRepository;//Field injection is not best practice

    @Autowired
    public PlayerRepositoryTest(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @DisplayName("Player Repository Save - Should return a Saved Player")
    @Test
    public void saveTest_ShouldReturnSavedPlayer(){
        Player player = Player.builder().build();

        Player savedPlayer = playerRepository.save(player);
        Assertions.assertThat(player).isNotNull();
    }

    @DisplayName("Player Repository FindAll - Should return a list of players")
    @Test
    public void findAllTest_ShouldReturnListOfPlayers() {
        Player player1 = Player.builder().build();
        Player player2 = Player.builder().build();

        playerRepository.save(player1);
        playerRepository.save(player2);

        List<Player> players = playerRepository.findAll();

        Assertions.assertThat(players).isNotNull();
        Assertions.assertThat(players).hasSize(2);
    }
}
