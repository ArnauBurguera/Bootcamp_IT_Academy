package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.exceptions.PlayerNotFoundException;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.repository.GameRepository;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public Game playGame(Integer playerId) {
        Game game = rollDice();

        Player player = findPlayer(playerId);
        player.addGame(game);
        playerRepository.save(player);

        return game;
    }

    private Game rollDice(){
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;
        boolean won = (dice1 + dice2 == 7);

        return new Game(dice1,dice2,won);
    }

    public void deleteGamesForPlayer(Integer playerId) {
        Player player = findPlayer(playerId);
        player.deleteAllGames();
        playerRepository.save(player);
    }

    public List<Game> getGamesForPlayer(Integer playerId) {
        return findPlayer(playerId).getGames();
    }

    public Player findPlayer(Integer playerId){
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + playerId));
    }
}
