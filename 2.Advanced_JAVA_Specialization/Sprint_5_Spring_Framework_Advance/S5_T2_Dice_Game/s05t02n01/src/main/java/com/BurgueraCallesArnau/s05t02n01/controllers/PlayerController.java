package com.BurgueraCallesArnau.s05t02n01.controllers;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        // Implementation for creating a new player
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayerName(@PathVariable Long id, @RequestBody String name) {
        // Implementation for updating player name
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        // Implementation for retrieving all players
        return null;
    }

    // Other methods for handling player-related operations
}
