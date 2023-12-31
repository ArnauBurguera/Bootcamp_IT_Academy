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
import java.util.Optional;

@DataMongoTest
@TestPropertySource(properties = {
        "spring.test.database.replace=none",
        "spring.data.mongodb.uri=mongodb://${mongodb.host}:${mongodb.port}/testdb"
})
public class PlayerRepositoryTest {

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
        Assertions.assertThat(savedPlayer).isNotNull();
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

    @DisplayName("Player Repository Delete - Should delete a player")
    @Test
    public void deleteTest_ShouldDeletePlayer() {
        Player player = Player.builder().build();
        playerRepository.save(player);

        playerRepository.delete(player);

        Assertions.assertThat(playerRepository.findById(player.getId())).isEmpty();
        Assertions.assertThat(playerRepository.findAll().isEmpty()).isTrue();
    }

    @DisplayName("Player Repository FindByEmail - Should return a player with the given email")
    @Test
    public void findByEmailTest_ShouldReturnPlayer() {
        String email = "test@example.com";
        Player player = Player.builder().email(email).build();
        playerRepository.save(player);

        Player foundPlayer = playerRepository.findByEmail(email).get();

        Assertions.assertThat(foundPlayer).isNotNull();
        Assertions.assertThat(foundPlayer.getEmail()).isEqualTo(email);
    }

    @DisplayName("Player Repository FindById - Should return a player with the given ID")
    @Test
    public void findByIdTest_ShouldReturnPlayer() {
        Player player = Player.builder().build();
        playerRepository.save(player);

        Optional<Player> foundPlayerOptional = playerRepository.findById(player.getId());

        Assertions.assertThat(foundPlayerOptional).isPresent();
        Assertions.assertThat(foundPlayerOptional.get()).isEqualTo(player);
    }
}
