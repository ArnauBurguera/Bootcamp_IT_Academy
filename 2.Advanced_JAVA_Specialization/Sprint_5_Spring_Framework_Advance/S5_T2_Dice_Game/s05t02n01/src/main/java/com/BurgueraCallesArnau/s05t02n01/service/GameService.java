package com.BurgueraCallesArnau.s05t02n01.service;

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
        // Simulate dice roll (you can use a random number generator)
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;

        // Determine if the game is won based on the sum of dice
        boolean won = (dice1 + dice2 == 7);

        // Create a new game record
        Game game = new Game();
        game.setDice1(dice1);
        game.setDice2(dice2);
        game.setWon(won);

        // Find the player by id
        Player player = findPlayer(playerId);
        player.addGame(game);
        playerRepository.save(player);

        return game;
    }



    public void deleteGamesForPlayer(Integer playerId) {
        Player player = findPlayer(playerId);
        gameRepository.deleteAll(player.getGames());
    }

    public List<Game> getGamesForPlayer(Integer playerId) {
        return findPlayer(playerId).getGames();
    }

    private Player findPlayer(Integer playerId){
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }
}
