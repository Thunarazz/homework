package com.example.guessgame.controller;

import com.example.guessgame.model.Game;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/game")
public class GameController {

    private final Map<String, Game> games = new HashMap<>();

    // Создание новой игры
    @PostMapping
    public Map<String, String> startGame() {
        String gameId = UUID.randomUUID().toString();
        games.put(gameId, new Game());

        return Map.of("gameId", gameId);
    }

    // Угадывание числа
    @GetMapping("/{gameId}/guess/{number}")
    public String guessNumber(@PathVariable String gameId, @PathVariable int number) {
        Game game = games.get(gameId);
        if (game == null) {
            return "Game not found.";
        }

        game.incrementAttempts();
        int target = game.getNumberToGuess();

        if (number > target) {
            return "Nr is smaller";
        } else if (number < target) {
            return "Nr is bigger";
        } else {
            return "Correct, it took you " + game.getAttempts() + " times";
        }
    }
}