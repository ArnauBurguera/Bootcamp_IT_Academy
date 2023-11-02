package com.BurgueraCallesArnau.s05t02n01.controllers;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players/{id}/games")
public class GameController {

    @PostMapping
    public ResponseEntity<Game> playGame(@PathVariable Long id) {
        // Implementation for playing a game and recording the result
        return null;
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGamesForPlayer(@PathVariable Long id) {
        // Implementation for deleting all games for a player
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getPlayerGames(@PathVariable Long id) {
        // Implementation for retrieving all games for a player
        return null;
    }

    // Other methods for handling game-related operations
}
