package com.BurgueraCallesArnau.s05t02n01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DataMongoTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerRepositoryTest {
    //TODO: save, findByEmail(String email), findById(playerId)

    private final PlayerRepository playerRepository;//Field injection is not best practice

    @Autowired
    public PlayerRepositoryTest(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
}
