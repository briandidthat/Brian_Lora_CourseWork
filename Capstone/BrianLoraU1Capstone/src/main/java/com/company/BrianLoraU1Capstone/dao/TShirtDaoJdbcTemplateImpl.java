package com.company.BrianLoraU1Capstone.dao;


import com.company.BrianLoraU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TShirt addTShirt(TShirt tShirt) {
        return null;
    }

    @Override
    public TShirt getTShirtById(int id) {
        return null;
    }

    @Override
    public List<TShirt> getAllTShirts() {
        return null;
    }

    @Override
    public List<TShirt> getTShirtsBySize(String size) {
        return null;
    }

    @Override
    public List<TShirt> getTShirtsByColor(String color) {
        return null;
    }

    @Override
    public void updateTShirt(TShirt tShirt) {

    }

    @Override
    public void deleteTShirt(int id) {

    }
}
