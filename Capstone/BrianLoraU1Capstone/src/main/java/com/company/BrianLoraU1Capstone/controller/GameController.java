package com.company.BrianLoraU1Capstone.controller;

import com.company.BrianLoraU1Capstone.exception.NotFoundException;
import com.company.BrianLoraU1Capstone.service.GameService;
import com.company.BrianLoraU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody GameViewModel gameViewModel) {
        return gameService.saveGame(gameViewModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return gameService.findAllGames();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGameById(@PathVariable("id") int id) {
        GameViewModel game = gameService.findGameById(id);
        if (game == null) {
            throw new NotFoundException("Unfortunately, we do not have a game with that id: " + id + ".");
        }
        return game;
    }

    @GetMapping("/{title}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGameByTitle(@PathVariable("title") String title) {
        GameViewModel game = gameService.findGameByTitle(title);
        if (game == null) {
            throw new NotFoundException("Unfortunately, we could not find a game with the title: " + title + ".");
        }
        return game;
    }

    @GetMapping("/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
        List<GameViewModel> games = gameService.findGamesByStudio(studio);
        if (games != null && games.size() == 0) {
            throw new NotFoundException("Unfortunately, we could not find any games by the studio: " + studio + ".");
        }
        return games;
    }

    @GetMapping("/{rating}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByRating(@PathVariable("rating") String rating) {
        List<GameViewModel> games = gameService.findGamesByRating(rating);
        if (games != null && games.size() == 0) {
            throw new NotFoundException("Unfortunately, we could not find any games with the rating: " + rating + ".");
        }
        return gameService.findGamesByRating(rating);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int id, @RequestBody GameViewModel gameViewModel) {
        if (gameViewModel.getId() == 0)
            gameViewModel.setId(id);
        if (id != gameViewModel.getId()) {
            throw new IllegalArgumentException("Game ID on path must match the ID in the game object");
        }
        gameService.updateGame(gameViewModel);
    }
}
