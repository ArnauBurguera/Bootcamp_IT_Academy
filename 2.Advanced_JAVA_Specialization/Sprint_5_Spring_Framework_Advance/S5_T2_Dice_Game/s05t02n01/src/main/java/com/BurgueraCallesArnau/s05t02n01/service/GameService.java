package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;public Game playGame(Player player) {
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
        game.setPlayer(player);

        // Save the game record to the database
        return gameRepository.save(game);
    }

    public void deleteGamesForPlayer(Player player) {
        // Delete all game records associated with the player
        gameRepository.deleteByPlayer(player);
    }

    public List<Game> getPlayerGames(Player player) {
        // Retrieve all game records for the player
        return gameRepository.findByPlayer(player);
    }

    public double calculateSuccessPercentage(Player player) {
        // Calculate the success percentage
        List<Game> games = gameRepository.findByPlayer(player);
        if (games.isEmpty()) {
            return 0.0;
        }
        long wonGames = games.stream().filter(Game::isWon).count();
        return (double) wonGames / games.size() * 100;
    }
}
