package com.trilogyed.gamestore.controller;

import com.trilogyed.gamestore.exception.NotFoundException;
import com.trilogyed.gamestore.model.Game;
import com.trilogyed.gamestore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/gamestore/games")
public class GameController {
    @Autowired
    GameService gameService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(Principal principal, @RequestBody @Valid Game game) {
        return gameService.saveGame(game);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameService.findAllGames();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable("id") int id) {
        Game game = gameService.findGameById(id);
        if (game == null) {
            throw new NotFoundException("Unfortunately, we do not have a game with that id: " + id + ".");
        }
        return game;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(Principal principal, @PathVariable("id") int id) {
        gameService.removeGame(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int id, @RequestBody @Valid Game game) {
        if (game.getGameId() == 0)
            game.setGameId(id);
        if (id != game.getGameId()) {
            throw new IllegalArgumentException("Game ID on path must match the ID in the game object");
        }
        gameService.updateGame(game);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameByTitle(@PathVariable("title") String title) {
        Game game = gameService.findGameByTitle(title);
        if (game == null) {
            throw new NotFoundException("Unfortunately, we could not find a game with the title: " + title + ".");
        }
        return game;
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable("studio") String studio) {
        List<Game> games = gameService.findGamesByStudio(studio);
        if (games == null) {
            throw new NotFoundException("Unfortunately, we could not find any games by the studio: " + studio + ".");
        }
        return games;
    }

    @GetMapping("/rating/{rating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByRating(@PathVariable("rating") String rating) {
        List<Game> games = gameService.findGamesByRating(rating);
        if (games == null) {
            throw new NotFoundException("Unfortunately, we could not find any games with the rating: " + rating + ".");
        }
        return games;
    }
}
