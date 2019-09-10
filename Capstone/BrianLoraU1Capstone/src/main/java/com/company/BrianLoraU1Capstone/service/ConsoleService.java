package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.ConsoleDao;
import com.company.BrianLoraU1Capstone.model.Console;
import com.company.BrianLoraU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Console Service
 * Purpose : Service layer class that will perform all necessary CONSOLE operations based on user input.
 * Private methods : buildConsoleViewModel(). Used to build consoleViewModel for data management in a life-cycle manner.
 * Public methods : saveConsole(), findConsoleById(), findConsoleByManufacturer(), findAllConsoles(),
 * updateConsole(), removeConsole(). Used to perform all CRUD operations that will be accessed by the ConsoleController.
 */

@Component
public class ConsoleService {
    ConsoleDao consoleDao;

    @Autowired
    public ConsoleService(ConsoleDao consoleDao) {
        this.consoleDao = consoleDao;
    }

    @Transactional
    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        console = consoleDao.addConsole(console);
        consoleViewModel.setId(console.getConsoleId());

        return consoleViewModel;
    }

    public ConsoleViewModel findConsoleById(int id) {
        Console console = consoleDao.getConsoleById(id);
        if (console == null) {
            return null;
        } else {
            return buildConsoleViewModel(console);
        }
    }

    public List<ConsoleViewModel> findConsolesByManufacturer(String manufacturer) {
        List<Console> consoles = consoleDao.getConsolesByManufacturer(manufacturer);
        List<ConsoleViewModel> cvmList = new ArrayList<>();

        for (Console c : consoles) {
            ConsoleViewModel cModel = buildConsoleViewModel(c);
            cvmList.add(cModel);
        }
        return cvmList;
    }

    public List<ConsoleViewModel> findAllConsoles() {
        List<Console> consoles = consoleDao.getAllConsoles();
        List<ConsoleViewModel> cvmList = new ArrayList<>();

        for (Console c : consoles) {
            ConsoleViewModel cModel = buildConsoleViewModel(c);
            cvmList.add(cModel);
        }
        return cvmList;
    }

    public void updateConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setConsoleId(consoleViewModel.getId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        consoleDao.updateConsole(console);
    }

    public void removeConsole(int id) {
        consoleDao.deleteConsole(id);
    }


    private ConsoleViewModel buildConsoleViewModel(Console console) {
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;
    }
}
