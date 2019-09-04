package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Console addConsole(Console console) {
        return null;
    }

    @Override
    public Console getConsoleById(int id) {
        return null;
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return null;
    }

    @Override
    public void updateConsole(Console console) {

    }

    @Override
    public void deleteConsole(int id) {

    }
}
