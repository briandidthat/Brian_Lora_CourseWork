package com.trilogyed.gamestore.service;

import com.trilogyed.gamestore.dao.GameDao;
import com.trilogyed.gamestore.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameService {
    GameDao gameDao;

    @Autowired
    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public Game findGameById(int id) {
        Game game = gameDao.getGameById(id);
        if (game == null) {
            return null;
        }
        return game;
    }

    public Game findGameByTitle(String title) {
        Game game = gameDao.getGameByTitle(title);
        if (game == null) {
            return null;
        }
        return game;
    }

    public List<Game> findGamesByRating(String esrbRating) {
        List<Game> games = gameDao.getGamesByRating(esrbRating);
        if (games == null) {
            return null;
        }
        return games;
    }

    public List<Game> findGamesByStudio(String studio) {
        List<Game> games = gameDao.getGamesByStudio(studio);
        if (games == null) {
            return null;
        }
        return games;
    }

    public List<Game> findAllGames() {
        return gameDao.getAllGames();
    }

    @Transactional
    public Game saveGame(Game game) {
        return gameDao.addGame(game);
    }

    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    public void removeGame(int id) {
        gameDao.deleteGame(id);
    }

}
