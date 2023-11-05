package com.BurgueraCallesArnau.s05t02n01.controllers.rest;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.createPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayerName(@PathVariable int id, @RequestBody String name) {
        Player updatedPlayer = playerService.updatePlayerName(id, name);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Player has been deleted.");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<List<Game>> getPlayerGames(@PathVariable int id) {
        List<Game> games = playerService.getPlayerGames(id);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}/successPercentage")
    public ResponseEntity<Double> calculateSuccessPercentage(@PathVariable int id) {
        double successPercentage = playerService.calculateSuccessPercentage(id);
        return ResponseEntity.ok(successPercentage);
    }

    @GetMapping("/averageSuccess")
    public ResponseEntity<Double> calculateAverageSuccessPercentage() {
        double averageSuccessPercentage = playerService.calculateAverageSuccessPercentage();
        return ResponseEntity.ok(averageSuccessPercentage);
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<Player>> getRankingBasedOnSuccessPercentage() {
        List<Player> ranking = playerService.getPlayersRankedBySuccessPercentage();
        return ResponseEntity.ok(ranking);
    }
}
