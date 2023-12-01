package com.BurgueraCallesArnau.s05t02n01.repository;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MongoDBContainer;

import java.util.List;

@DataMongoTest
@TestPropertySource(properties = {
        "spring.test.database.replace=none",
        "spring.data.mongodb.uri=mongodb://${mongodb.host}:${mongodb.port}/testdb"
})
public class PlayerRepositoryTest {
    //TODO: delete, findByEmail(String email), findById(playerId)
    //"mongo:latest" in next line downloads latest Docker image for Mongo
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    private final PlayerRepository playerRepository;//Field injection is not best practice

    @Autowired
    public PlayerRepositoryTest(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @BeforeAll
    public static void beforeAll() {
        mongoDBContainer.start();
        System.setProperty("mongodb.host", mongoDBContainer.getHost());
        System.setProperty("mongodb.port", String.valueOf(mongoDBContainer.getMappedPort(27017)));
    }

    @BeforeEach
    void setUp(){
        playerRepository.deleteAll();
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
