package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.TShirtDao;
import com.company.BrianLoraU1Capstone.dao.TShirtDaoJdbcTemplateImpl;
import com.company.BrianLoraU1Capstone.model.TShirt;
import com.company.BrianLoraU1Capstone.viewmodel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    public void findTShirtsBySizeAndColor() {

    }

    @Test
    public void findTAllTShirts() {
        List<TShirt> tShirts = tShirtDao.getAllTShirts();
        assertEquals(1, tShirts.size());
    }

    @Test
    public void saveFindTShirtByIdRemove() {
        // ADD TSHIRT
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("20.00"));
        tShirt = tShirtDao.addTShirt(tShirt);
        // GET TSHIRT
        TShirt tShirt1 = tShirtDao.getTShirtById(tShirt.getTShirtId());
        assertEquals(tShirt1, tShirt);
    }

    @Test
    public void updateTShirt() {
    }

    private void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);
        TShirt tShirt = new TShirt();
        tShirt.setTShirtId(1);
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("20.00"));

        TShirt tShirt1 = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("20.00"));

        List<TShirt> tList = new ArrayList<>();
        tList.add(tShirt);

        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt1);
        doReturn(tShirt).when(tShirtDao).getTShirtById(1);
        doReturn(tList).when(tShirtDao).getAllTShirts();
        doReturn(tList).when(tShirtDao).getTShirtsByColor("Blue");
        doReturn(tList).when(tShirtDao).getTShirtsBySize("Medium");
    }
}