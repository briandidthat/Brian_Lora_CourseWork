package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.GameDao;
import com.company.BrianLoraU1Capstone.dao.GameDaoJdbcTemplateImpl;
import org.junit.Before;
import org.junit.Test;

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
    public void findGameById() {
    }

    @Test
    public void findGameByTitle() {
    }

    @Test
    public void findGamesByRating() {
    }

    @Test
    public void findGamesByStudio() {
    }

    @Test
    public void findAllGames() {
    }

    @Test
    public void saveGame() {
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void removeGame() {
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);
    }
}