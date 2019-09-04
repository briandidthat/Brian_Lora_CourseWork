package com.company.BrianLoraU1Capstone.dao;


import com.company.BrianLoraU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GameDaoJdbcTemplateImpl implements GameDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Game addGame(Game game) {
        return null;
    }

    @Override
    public Game getGameByTitle(String title) {
        return null;
    }

    @Override
    public Game getGameById(int id) {
        return null;
    }

    @Override
    public List<Game> getAllGames() {
        return null;
    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return null;
    }

    @Override
    public List<Game> getGamesByRating(String esrbRating) {
        return null;
    }

    @Override
    public void updateGame(Game game) {

    }

    @Override
    public void deleteGame(int id) {

    }
}
