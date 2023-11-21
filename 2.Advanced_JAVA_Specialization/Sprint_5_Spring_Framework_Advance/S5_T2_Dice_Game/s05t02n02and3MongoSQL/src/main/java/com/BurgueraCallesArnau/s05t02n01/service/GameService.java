package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.exceptions.PlayerNotFoundException;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.repository.GameRepository;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import com.BurgueraCallesArnau.s05t02n01.utils.Constants;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public Game playGame(ObjectId playerId) {
        Player player = findPlayer(playerId);
        Game game = rollDice(player.getId());

        player.addGame(game);
        gameRepository.save(game);
        playerRepository.save(player);

        return game;
    }

    private Game rollDice(ObjectId playerId){
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;

        return Game.builder()
                .dice1(dice1)
                .dice2(dice2)
                .won(dice1 + dice2 == 7)
                .playerId(playerId)
                .build();
    }

    public void deleteGamesForPlayer(ObjectId playerId) {
        Player player = findPlayer(playerId);
        player.deleteAllGames();
        playerRepository.save(player);
    }

    public List<Game> getGamesForPlayer(ObjectId playerId) {
        return findPlayer(playerId).getGames();
    }

    public Player findPlayer(ObjectId playerId){
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(Constants.PlayerNotFoundExceptionMessage + playerId));
    }
}
