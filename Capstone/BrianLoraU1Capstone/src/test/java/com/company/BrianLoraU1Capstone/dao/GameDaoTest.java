package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {
    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> games = gameDao.getAllGames();
        for (Game g : games) {
            gameDao.deleteGame(g.getGameId());
        }
    }

    @Test
    public void addGetDeleteGame() {
        // add
        Game game = new Game();
        game.setTitle("DeadPool");
        game.setEsrbRating("R");
        game.setDescription("Play as deadpool");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Nomad Studios");
        game.setQuantity(4);
        game = gameDao.addGame(game);
        // get
        Game game1 = gameDao.getGameById(game.getGameId());
        assertEquals(game1, game);
        // delete
        gameDao.deleteGame(game.getGameId());
        game1 = gameDao.getGameById(game.getGameId());
        // test for null value to ensure it was deleted
        assertNull(game1);
    }

    @Test
    public void getGameByTitle() {
        Game game = new Game();
        game.setTitle("DeadPool");
        game.setEsrbRating("R");
        game.setDescription("Play as deadpool");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Nomad Studios");
        game.setQuantity(4);
        game = gameDao.addGame(game);

        Game game1 = gameDao.getGameByTitle("DeadPool");

        assertEquals(game1, game);
    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("DeadPool");
        game.setEsrbRating("R");
        game.setDescription("Play as deadpool");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Nomad Studios");
        game.setQuantity(4);
        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("GTA5");
        game.setEsrbRating("R");
        game.setDescription("grand theft auto 5");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("GTA Studios");
        game.setQuantity(10);
        gameDao.addGame(game);

        List<Game> gameList = gameDao.getAllGames();

        assertEquals(2, gameList.size());
    }

    @Test
    public void getGamesByStudio() {
        Game game = new Game();
        game.setTitle("DeadPool");
        game.setEsrbRating("R");
        game.setDescription("Play as deadpool");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Nomad Studios");
        game.setQuantity(4);
        game = gameDao.addGame(game);

        List<Game> games = gameDao.getGamesByStudio("Nomad Studios");

        assertEquals(1, games.size());
    }

    @Test
    public void getGamesByRating() {
        Game game = new Game();
        game.setTitle("DeadPool");
        game.setEsrbRating("R");
        game.setDescription("Play as deadpool");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Nomad Studios");
        game.setQuantity(4);
        game = gameDao.addGame(game);

        List<Game> games = gameDao.getGamesByRating("R");

        assertEquals(1, games.size());
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("DeadPool");
        game.setEsrbRating("R");
        game.setDescription("Play as deadpool");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Nomad Studios");
        game.setQuantity(4);
        game = gameDao.addGame(game);
        // save new values and update in db
        game.setPrice(new BigDecimal("49.99"));
        game.setQuantity(3);
        gameDao.updateGame(game);
        // get and compare
        Game game1 = gameDao.getGameById(game.getGameId());
        assertEquals(game1, game);
    }

    @Test
    public void updateGameInventory() {
        Game game = new Game();
        game.setTitle("DeadPool");
        game.setEsrbRating("R");
        game.setDescription("Play as deadpool");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Nomad Studios");
        game.setQuantity(10);
        game = gameDao.addGame(game);

        game.setQuantity(4);
        gameDao.updateGameInventory(game.getGameId(), game.getQuantity());

        Game game1 = gameDao.getGameById(game.getGameId());
        assertEquals(game1, game);
    }

}