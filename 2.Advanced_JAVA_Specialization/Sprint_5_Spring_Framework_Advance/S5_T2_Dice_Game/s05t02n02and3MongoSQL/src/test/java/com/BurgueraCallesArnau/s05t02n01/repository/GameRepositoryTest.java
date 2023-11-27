package com.BurgueraCallesArnau.s05t02n01.repository;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void gameRepository_SaveTest(){
        Game game = Game.builder()
                .dice1(3)
                .dice2(4)
                .won(true)
                .playerId(new ObjectId("655c7adf06e4ae59f47979ca"))
                .build();

        Game savedGame = gameRepository.save(game);
        Assertions.assertNotNull(savedGame);
    }


}
