package com.BurgueraCallesArnau.s05t02n01.controllers.rest;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Game;
import com.BurgueraCallesArnau.s05t02n01.service.GameService;
import com.BurgueraCallesArnau.s05t02n01.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping(Constants.gameControllerRequestMapping)
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping(Constants.playGame)
    @Operation(summary = Constants.playGameSummary, description = Constants.playGameDsc)
    public ResponseEntity<Game> playGame(@Parameter(description = Constants.playGameParam, required = true) @PathVariable int playerId) {
        Game game = gameService.playGame(playerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @DeleteMapping(Constants.deleteGamesForPlayer)
    @Operation(summary = Constants.deleteGamesForPlayerSummary, description = Constants.deleteGamesForPlayerDscr)
    public ResponseEntity<String> deleteGamesForPlayer(@Parameter(description = Constants.deleteGamesForPlayerParam, required = true) @PathVariable int playerId) {
        gameService.deleteGamesForPlayer(playerId);

        return ResponseEntity.ok(Constants.deleteGamesForPlayerResponseBody);
    }
}
