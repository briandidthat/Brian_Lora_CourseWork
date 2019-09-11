package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.ConsoleDao;
import com.company.BrianLoraU1Capstone.dao.ConsoleDaoJdbcTemplateImpl;
import com.company.BrianLoraU1Capstone.model.Console;
import com.company.BrianLoraU1Capstone.viewmodel.ConsoleViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class ConsoleServiceTest {

    ConsoleDao consoleDao;
    ConsoleService consoleService;

    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        consoleService = new ConsoleService(consoleDao);
    }

    @Test
    public void saveFindConsoleByIdRemove() {
        // save
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setModel("PS4");
        cvm.setManufacturer("Sony");
        cvm.setMemoryAmount("400 GB");
        cvm.setProcessor("i7");
        cvm.setPrice(new BigDecimal("25.00"));
        cvm.setQuantity(10);
        cvm = consoleService.saveConsole(cvm);
        // find by id
        System.out.println(cvm.getId());
        ConsoleViewModel fromService = consoleService.findConsoleById(cvm.getId());
        assertEquals(fromService, cvm);
        // delete
        consoleService.removeConsole(cvm.getId());
        ConsoleViewModel deleted = consoleService.findConsoleById(cvm.getId());
        assertNull(fromService);
    }

    @Test
    public void findConsolesByManufacturer() {
        List<Console> cList = consoleDao.getConsolesByManufacturer("Sony");
        assertEquals(1, cList.size());
    }

    @Test
    public void findAllConsoles() {
        List<Console> cList = consoleDao.getAllConsoles();
        assertEquals(1, cList.size());
    }

    @Test
    public void updateConsole() {
        ConsoleViewModel console = new ConsoleViewModel();
        console.setId(10);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("400 GB");
        console.setProcessor("i7");
        console.setPrice(new BigDecimal("25.00"));
        console.setQuantity(10);

        console.setModel("PS5");
        console.setProcessor("2TB");
        consoleService.updateConsole(console);

        ConsoleViewModel fromService = consoleService.findConsoleById(console.getId());
        assertEquals(fromService, console);
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setConsoleId(10);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("400 GB");
        console.setProcessor("i7");
        console.setPrice(new BigDecimal("25.00"));
        console.setQuantity(10);

        Console console1 = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("400 GB");
        console.setProcessor("i7");
        console.setPrice(new BigDecimal("25.00"));
        console.setQuantity(10);

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsoleById(10);
        doReturn(cList).when(consoleDao).getAllConsoles();
    }
}