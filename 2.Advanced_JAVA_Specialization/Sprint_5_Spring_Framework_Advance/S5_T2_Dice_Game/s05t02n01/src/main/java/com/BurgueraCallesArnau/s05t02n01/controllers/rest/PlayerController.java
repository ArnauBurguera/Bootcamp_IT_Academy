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
@RequestMapping(Constants.playerControllerRequestMapping)
@Tag(name = Constants.swaggerTagName, description = Constants.swaggerTagDescription)
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping(Constants.createPlayer)
    @Operation(summary = Constants.createPlayerSummary, description = Constants.createPlayerDescription)
    public ResponseEntity<Player> createPlayer(@Parameter(description = Constants.createPlayerParam, required = true)@RequestBody Player player) {
        Player createdPlayer = playerService.createPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @PutMapping(Constants.updatePlayerName)
    @Operation(summary = Constants.updatePlayerSummary, description = Constants.updatePlayerDescr)
    public ResponseEntity<Player> updatePlayerName(@Parameter(description = Constants.updatePlayerParam, required = true)@PathVariable int id, @RequestBody String name) {
        Player updatedPlayer = playerService.updatePlayerName(id, name);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping(Constants.deletePlayer)
    @Operation(summary = Constants.deletePlayerSummary, description = Constants.deletePlayerDescr)
    public ResponseEntity<String> deletePlayer(@Parameter(description = Constants.deletePlayerParam, required = true)@PathVariable int id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok(Constants.deletePlayerResponseBody);
    }

    @GetMapping(Constants.getAllPlayers)
    @Operation(summary = Constants.getAllPlayersSummary, description = Constants.getAllPlayersDescr)
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping(Constants.getPlayerGames)
    @Operation(summary = Constants.getPlayerGamesSummary, description = Constants.getPlayerGamesDescr)
    public ResponseEntity<List<Game>> getPlayerGames(@Parameter(description = Constants.getPlayerGamesParam, required = true)@PathVariable int id) {
        List<Game> games = playerService.getPlayerGames(id);
        return ResponseEntity.ok(games);
    }

    @GetMapping(Constants.calculateSuccessPercentage)
    @Operation(summary = Constants.calculateSuccessPercentageSummary, description = Constants.calculateSuccessPercentageDescr)
    public ResponseEntity<Double> calculateSuccessPercentage(@Parameter(description = Constants.calculateSuccessPercentageParam, required = true)@PathVariable int id) {
        double successPercentage = playerService.calculateSuccessPercentage(id);
        return ResponseEntity.ok(successPercentage);
    }

    @GetMapping(Constants.calculateAverageSuccessPercentage)
    @Operation(summary = Constants.calculateAvSccssPrcntgeSummary, description = Constants.calculateAvSccssPrcntgeDscr)
    public ResponseEntity<Double> calculateAverageSuccessPercentage() {
        double averageSuccessPercentage = playerService.calculateAverageSuccessPercentage();
        return ResponseEntity.ok(averageSuccessPercentage);
    }

    @GetMapping(Constants.getRankingBasedOnSuccessPercentage)
    @Operation(summary = Constants.getRankingSummary, description = Constants.getRankingDescr)
    public ResponseEntity<List<Player>> getRankingBasedOnSuccessPercentage() {
        List<Player> ranking = playerService.getPlayersRankedBySuccessPercentage();
        return ResponseEntity.ok(ranking);
    }

    @GetMapping(Constants.getLoser)
    @Operation(summary = Constants.getLoserSummary, description = Constants.getLoserDscr)
    public ResponseEntity<Player> getLoser() {
        Player loser = playerService.getLoser();
        if (loser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(loser);
    }

    @GetMapping(Constants.getWinner)
    @Operation(summary = Constants.getWinnerSummary, description = Constants.getWinnerDscr)
    public ResponseEntity<Player> getWinner() {
        Player winner = playerService.getWinner();
        if (winner == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(winner);
    }
}
