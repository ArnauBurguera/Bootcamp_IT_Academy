package com.BurgueraCallesArnau.s05t02n01.repository;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import org.bson.types.ObjectId;
/*import org.junit.jupiter.api.Assertions;*/
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void gameRepository_SaveTest_ShouldReturnSavedGame(){
        Game game = Game.builder()
                .dice1(3)
                .dice2(4)
                .won(true)
                .playerId(new ObjectId("655c7adf06e4ae59f47979ca"))
                .build();

        Game savedGame = gameRepository.save(game);
        Assertions.assertNotNull(savedGame);
        Assertions.assertTrue(savedGame.getId() > 0);
    }

    @Test
    public void gameRepository_FindAllTest_ShouldReturnMoreThanOneGame(){
        Game game = Game.builder()
                .dice1(3)
                .dice2(4)
                .won(true)
                .playerId(new ObjectId("655c7adf06e4ae59f47979ca"))
                .build();
        Game game2 = Game.builder()
                .dice1(5)
                .dice2(6)
                .won(false)
                .playerId(new ObjectId("655c7adf06e4ae59f47612ca"))
                .build();

        gameRepository.save(game);
        gameRepository.save(game2);

        List<Game> gameList = gameRepository.findAll();
        Assertions.assertThat(gameList).isInstanceOf(List.class);

    }


}
