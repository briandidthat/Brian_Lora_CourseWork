package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.GameDao;
import com.company.BrianLoraU1Capstone.dao.GameDaoJdbcTemplateImpl;
import com.company.BrianLoraU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

public class GameServiceTest {

    GameDao gameDao;
    GameService gameService;

    @Before
    public void setUp() throws Exception {
        setUpGameDaoMock();
        gameService = new GameService(gameDao);
    }

    @Test
    public void saveFindGameByIdRemove() {
    }

    @Test
    public void findGameByTitleRatingStudio() {
    }

    @Test
    public void findAllGames() {
    }

    @Test
    public void updateGame() {
    }


    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);
        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Madden 20");
        game.setEsrbRating("R");
        game.setDescription("Play NFL simulation games with your friends.");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("NVMA Studios");
        game.setQuantity(20);

        Game game1 = new Game();
        game1.setTitle("Madden 20");
        game1.setEsrbRating("R");
        game1.setDescription("Play NFL simulation games with your friends.");
        game1.setPrice(new BigDecimal("59.99"));
        game1.setStudio("NVMA Studios");
        game1.setQuantity(20);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGameById(1);
        doReturn(game).when(gameDao).getGameByTitle("Madden 20");
        doReturn(gList).when(gameDao).getAllGames();
        doReturn(gList).when(gameDao).getGamesByRating("R");
        doReturn(gList).when(gameDao).getGamesByStudio("NVMA Studios");
    }
}