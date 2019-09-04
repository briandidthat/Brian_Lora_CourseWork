package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.Game;

import java.util.List;

public interface GameDao {
    Game addGame(Game game);
    Game getGameByTitle(String title);
    Game getGameById(int id);

    List<Game> getAllGames();
    List<Game> getGamesByStudio(String studio);
    List<Game> getGamesByRating(String esrbRating);

    void updateGame(Game game);
    void deleteGame(int id);
}
