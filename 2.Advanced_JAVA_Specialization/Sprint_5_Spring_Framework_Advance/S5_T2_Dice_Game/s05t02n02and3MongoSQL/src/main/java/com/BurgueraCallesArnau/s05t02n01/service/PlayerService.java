package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.exceptions.PlayerNameAlreadyUsedException;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.repository.PlayerRepository;

import java.util.Comparator;

import com.BurgueraCallesArnau.s05t02n01.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameService gameService;

    public void createPlayer(Player player) {
        checkPlayerName(player);
        playerRepository.save(player);
    }

    private void checkPlayerName(Player player){
        if (player.getName() == null || player.getName().isEmpty()) {
            player.setName(Constants.playerDefaultName);
        } else if (getAllPlayers().stream().anyMatch(p -> p.getName().equals(player.getName()))) {
            throw new PlayerNameAlreadyUsedException(Constants.PlayerNameAlreadyUsedExceptionMessage + player.getName());
        }
    }

    public Player updatePlayerName(ObjectId id, String name) {
        Player player = gameService.findPlayer(id);
        player.setName(name);
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Game> getPlayerGames(ObjectId playerId) {
        return gameService.getGamesForPlayer(playerId);
    }

    public double calculateSuccessPercentage(ObjectId playerId) {
        List<Game> games = getPlayerGames(playerId);
        if (games.isEmpty()) {
            return 0.0;
        }
        int wonGames = (int) games.stream().filter(Game::isWon).count();
        return (double) wonGames / games.size() * 100;
    }

    public double calculateAverageSuccessPercentage() {
        List<Player> players = getAllPlayers();
        if (players.isEmpty()) {
            return 0.0;
        }
        double totalPercentage = players.stream()
                .mapToDouble(player -> calculateSuccessPercentage(player.getId()))
                .sum();
        return totalPercentage / players.size();
    }

    public List<Player> getPlayersRankedBySuccessPercentage() {
        List<Player> players = getAllPlayers();

        players.sort((player1, player2) -> {
            double successPercentage1 = calculateSuccessPercentage(player1.getId());
            double successPercentage2 = calculateSuccessPercentage(player2.getId());
            return Double.compare(successPercentage2, successPercentage1);
        });

        return players;
    }

    public Player getLoser() {
        List<Player> players = getAllPlayers();
        if (players.isEmpty()) {
            return null;
        }

        return players.stream()
                .min(Comparator.comparingDouble(player -> calculateSuccessPercentage(player.getId())))
                .orElse(null);
    }

    public Player getWinner() {
        List<Player> players = getAllPlayers();
        if (players.isEmpty()) {
            return null;
        }

        return players.stream()
                .max(Comparator.comparingDouble(player -> calculateSuccessPercentage(player.getId())))
                .orElse(null);
    }

    public void deletePlayer(ObjectId playerId) {
        gameService.deleteGamesFromRepo(playerId);
        playerRepository.delete(gameService.findPlayer(playerId));
    }
}
