package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.GameDao;
import com.company.BrianLoraU1Capstone.model.Game;
import com.company.BrianLoraU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public GameViewModel saveGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setDescription(gameViewModel.getEsrbRating());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        gameDao.addGame(game);
        gameViewModel.setId(game.getGameId());

        return gameViewModel;
    }

    @Transactional
    public void updateGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setGameId(gameViewModel.getId());
        game.setTitle(gameViewModel.getTitle());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        gameDao.updateGame(game);
    }

    @Transactional
    public void removeGame(int id) {
        gameDao.deleteGame(id);
    }


    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setDescription(game.getEsrbRating());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;
    }
}
