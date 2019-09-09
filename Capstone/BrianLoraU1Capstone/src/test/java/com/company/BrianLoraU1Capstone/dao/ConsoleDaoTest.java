package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.Console;
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
public class ConsoleDaoTest {
    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console c : consoles) {
            consoleDao.deleteConsole(c.getConsoleId());
        }
    }

    @Test
    public void addGetDeleteConsole() {
        // add
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("SONY");
        console.setMemoryAmount("1TB");
        console.setProcessor("I7");
        console.setPrice(new BigDecimal("599.99"));
        console.setQuantity(10);
        console = consoleDao.addConsole(console);
        // get
        Console console1 = consoleDao.getConsoleById(console.getConsoleId());
        assertEquals(console1, console);
        // delete
        consoleDao.deleteConsole(console.getConsoleId());
        console1 = consoleDao.getConsoleById(console.getConsoleId());
        // test for null to ensure it was deleted
        assertNull(console1);
    }

    @Test
    public void getConsolesByManufacturer() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("SONY");
        console.setMemoryAmount("1TB");
        console.setProcessor("I7");
        console.setPrice(new BigDecimal("599.99"));
        console.setQuantity(10);
        console = consoleDao.addConsole(console);

        List<Console> consoles = consoleDao.getConsolesByManufacturer("SONY");
        assertEquals(1, consoles.size());
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("SONY");
        console.setMemoryAmount("1TB");
        console.setProcessor("I7");
        console.setPrice(new BigDecimal("599.99"));
        console.setQuantity(10);
        console = consoleDao.addConsole(console);
        // set new values and update on DB
        console.setPrice(new BigDecimal("899.99"));
        console.setMemoryAmount("2TB");
        consoleDao.updateConsole(console);
        // get and compare
        Console console1 = consoleDao.getConsoleById(console.getConsoleId());
        assertEquals(console1, console);
    }

    @Test
    public void updateConsoleInventory() {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("SONY");
        console.setMemoryAmount("1TB");
        console.setProcessor("I7");
        console.setPrice(new BigDecimal("599.99"));
        console.setQuantity(10);
        console = consoleDao.addConsole(console);

        console.setQuantity(4);
        consoleDao.updateConsoleInventory(console.getConsoleId(), console.getQuantity());

        Console console1 = consoleDao.getConsoleById(console.getConsoleId());
        assertEquals(console1, console);
    }

}