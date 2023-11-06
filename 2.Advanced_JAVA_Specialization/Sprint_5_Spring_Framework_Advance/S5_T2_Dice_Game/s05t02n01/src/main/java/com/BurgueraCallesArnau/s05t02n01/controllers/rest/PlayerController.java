package com.BurgueraCallesArnau.s05t02n01.controllers.rest;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import com.BurgueraCallesArnau.s05t02n01.service.PlayerService;
import com.BurgueraCallesArnau.s05t02n01.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@Tag(name = Constants.swaggerTagName, description = Constants.swaggerTagDescription)
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    @Operation(summary = "Player creation", description = "This API allows you to create a new players.")
    public ResponseEntity<Player> createPlayer(@Parameter(description = "Player object", required = true)@RequestBody Player player) {
        Player createdPlayer = playerService.createPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Player update", description = "This API allows you to update existing players.")
    public ResponseEntity<Player> updatePlayerName(@Parameter(description = "Player id and New Player name", required = true)@PathVariable int id, @RequestBody String name) {
        Player updatedPlayer = playerService.updatePlayerName(id, name);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Player deletion", description = "This API allows you to delete players.")
    public ResponseEntity<String> deletePlayer(@Parameter(description = "Player id", required = true)@PathVariable int id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Player has been deleted.");
    }

    @GetMapping("/getAll")
    @Operation(summary = "Player List", description = "This API allows you to list all players.")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}/games")
    @Operation(summary = "Player Game Record", description = "This API allows you to list the Game Record of a given Player.")
    public ResponseEntity<List<Game>> getPlayerGames(@Parameter(description = "Player object", required = true)@PathVariable int id) {
        List<Game> games = playerService.getPlayerGames(id);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}/successPercentage")
    @Operation(summary = "Player Success Percentage", description = "This API shows the Success Percentage of a given Player.")
    public ResponseEntity<Double> calculateSuccessPercentage(@Parameter(description = "Player object", required = true)@PathVariable int id) {
        double successPercentage = playerService.calculateSuccessPercentage(id);
        return ResponseEntity.ok(successPercentage);
    }

    @GetMapping("/averageSuccess")
    @Operation(summary = "Average Success Percentage", description = "This API shows the Average Success Percentage of all the game history")
    public ResponseEntity<Double> calculateAverageSuccessPercentage() {
        double averageSuccessPercentage = playerService.calculateAverageSuccessPercentage();
        return ResponseEntity.ok(averageSuccessPercentage);
    }

    @GetMapping("/ranking")
    @Operation(summary = "Player ranking", description = "This API shows a ranking of Players based on their success percentage")
    public ResponseEntity<List<Player>> getRankingBasedOnSuccessPercentage() {
        List<Player> ranking = playerService.getPlayersRankedBySuccessPercentage();
        return ResponseEntity.ok(ranking);
    }

    @GetMapping("/ranking/loser")
    @Operation(summary = "Loser", description = "This API shows the Player with the lower Success Percentage")
    public ResponseEntity<Player> getLoser() {
        Player loser = playerService.getLoser();
        if (loser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(loser);
    }

    @GetMapping("/ranking/winner")
    @Operation(summary = "Winner", description = "This API shows the Player with the higher Success Percentage")
    public ResponseEntity<Player> getWinner() {
        Player winner = playerService.getWinner();
        if (winner == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(winner);
    }
}
