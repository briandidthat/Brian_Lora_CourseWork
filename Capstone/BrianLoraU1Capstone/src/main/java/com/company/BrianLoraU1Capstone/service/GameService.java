package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.GameDao;
import com.company.BrianLoraU1Capstone.model.Game;
import com.company.BrianLoraU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Service
 * Purpose : Service layer class that will perform all necessary GAME operations based on user input.
 * Private methods : buildGameViewModel(). Used to build gameViewModel for data management in a life-cycle manner.
 * Public methods : saveGame(), findGameById(), findGameByTitle(), findGamesByRating(), findGamesByStudio(),
 * updateGame(), removeGame(). Used to perform all CRUD operations that will be accessed by the GameController.
 */

@Component
public class GameService {
    GameDao gameDao;

    @Autowired
    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public GameViewModel findGameById(int id) {
        Game game = gameDao.getGameById(id);
        if (game == null) {
            return null;
        } else {
            return buildGameViewModel(game);
        }
    }

    public GameViewModel findGameByTitle(String title) {
        Game game = gameDao.getGameByTitle(title);
        if (game == null) {
            return null;
        } else {
            return buildGameViewModel(game);
        }
    }

    public List<GameViewModel> findGamesByRating(String esrbRating) {
        List<Game> gameList = gameDao.getGamesByRating(esrbRating);
        List<GameViewModel> gvmList = new ArrayList<>();

        for (Game g : gameList) {
            GameViewModel gModel = buildGameViewModel(g);
            gvmList.add(gModel);
        }
        return gvmList;
    }

    public List<GameViewModel> findGamesByStudio(String studio) {
        List<Game> gameList = gameDao.getGamesByStudio(studio);
        List<GameViewModel> gvmList = new ArrayList<>();

        for (Game g : gameList) {
            GameViewModel gModel = buildGameViewModel(g);
            gvmList.add(gModel);
        }
        return gvmList;
    }

    public List<GameViewModel> findAllGames() {
        List<Game> gameList = gameDao.getAllGames();
        List<GameViewModel> gvmList = new ArrayList<>();

        for (Game g : gameList) {
            GameViewModel gModel = buildGameViewModel(g);
            gvmList.add(gModel);
        }
        return gvmList;
    }

    @Transactional
    public GameViewModel saveGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        game = gameDao.addGame(game);

        gameViewModel.setId(game.getGameId());

        return gameViewModel;
    }

    public void updateGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setGameId(gameViewModel.getId());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        gameDao.updateGame(game);
    }

    public void removeGame(int id) {
        gameDao.deleteGame(id);
    }


    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setEsrbRating(game.getEsrbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;
    }
}
