package com.BurgueraCallesArnau.s05t02n01.controllers.rest;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/players/{playerId}/games")
@Tag(name = "Sucursal Management", description = "Operations pertaining to Sucursal Management")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/play")
    @Operation(summary = "Play a game for a specific player", description = "This API allows you to create a new games.")
    public ResponseEntity<Game> playGame(@Parameter(description = "The player id", required = true) @PathVariable int playerId) {
        Game game = gameService.playGame(playerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete all game records for a specific player", description = "This API allows you to delete game record for a given player")
    public ResponseEntity<String> deleteGamesForPlayer(@Parameter(description = "The player id", required = true)@PathVariable int playerId) {
        gameService.deleteGamesForPlayer(playerId);

        return ResponseEntity.ok("All games for the player have been deleted.");
    }

    @GetMapping("/list")
    @Operation(summary = "List game records for a specific player", description = "This API allows you to list game record for a given player")
    public ResponseEntity<List<Game>> getPlayerGames(@Parameter(description = "The player id", required = true)@PathVariable int playerId) {
        List<Game> games = gameService.getGamesForPlayer(playerId);
        return ResponseEntity.ok(games);
    }
}
