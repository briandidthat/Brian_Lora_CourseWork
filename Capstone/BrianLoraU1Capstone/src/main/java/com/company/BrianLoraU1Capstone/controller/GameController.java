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
            throw new NotFoundException("Unfortunately, we do not have a game with that id.");
        }
        return game;
    }

    @GetMapping("/{title}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGameByTitle(@PathVariable("title") String title) {
        return gameService.findGameByTitle(title);
    }

    @GetMapping("/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
        return gameService.findGamesByStudio(studio);
    }

    @GetMapping("/{rating}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByRating(@PathVariable("rating") String rating) {
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
