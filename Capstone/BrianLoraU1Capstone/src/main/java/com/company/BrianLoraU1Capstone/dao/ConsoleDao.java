package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {
    Console addConsole(Console console);
    Console getConsoleById(int id);

    List<Console> getConsolesByManufacturer(String manufacturer);

    void updateConsole(Console console);
    void deleteConsole(int id);
}
