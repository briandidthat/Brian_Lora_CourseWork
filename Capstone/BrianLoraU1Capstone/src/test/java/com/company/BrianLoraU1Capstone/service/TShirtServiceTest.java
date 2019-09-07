package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.TShirtDao;
import com.company.BrianLoraU1Capstone.dao.TShirtDaoJdbcTemplateImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TShirtServiceTest {

    TShirtDao tShirtDao;
    TShirtService tShirtService;

    @Before
    public void setUp() throws Exception {
        setUpTShirtDaoMock();
        tShirtService = new TShirtService(tShirtDao);
    }

    @Test
    public void findTShirtById() {
    }

    @Test
    public void findTShirtsByColor() {
    }

    @Test
    public void findTShirtsBySize() {
    }

    @Test
    public void findTAllTShirts() {
    }

    @Test
    public void saveTShirt() {
    }

    @Test
    public void updateTShirt() {
    }

    @Test
    public void removeShirt() {
    }

    @Test
    public void buildTShirtModel() {
    }

    private void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);
    }
}