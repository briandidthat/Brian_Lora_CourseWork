package com.trilogyed.gamestore.service;

import com.trilogyed.gamestore.dao.ConsoleDao;
import com.trilogyed.gamestore.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*Task:
 *
 */
@Component
public class ConsoleService {
    ConsoleDao consoleDao;

    @Autowired
    public ConsoleService(ConsoleDao consoleDao) {
        this.consoleDao = consoleDao;
    }

    @Transactional
    public Console saveConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    public Console findConsoleById(int id) {
        Console console = consoleDao.getConsoleById(id);
        if (console == null) {
            return null;
        }
        return console;
    }

    public List<Console> findConsolesByManufacturer(String manufacturer) {
        List<Console> consoles = consoleDao.getConsolesByManufacturer(manufacturer);
        if (consoles == null) {
            return null;
        }
        return consoles;
    }

    public List<Console> findAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    public void removeConsole(int id) {
        consoleDao.deleteConsole(id);
    }
}
