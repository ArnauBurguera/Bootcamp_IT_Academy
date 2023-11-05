package com.BurgueraCallesArnau.s05t02n01.controllers.rest;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.service.GameService;
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
    public ResponseEntity<Game> playGame(@PathVariable int playerId) {
        Game game = gameService.playGame(playerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteGamesForPlayer(@PathVariable int playerId) {
        gameService.deleteGamesForPlayer(playerId);

        return ResponseEntity.ok("All games for the player have been deleted.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Game>> getPlayerGames(@PathVariable int playerId) {
        List<Game> games = gameService.getGamesForPlayer(playerId);
        return ResponseEntity.ok(games);
    }
}
