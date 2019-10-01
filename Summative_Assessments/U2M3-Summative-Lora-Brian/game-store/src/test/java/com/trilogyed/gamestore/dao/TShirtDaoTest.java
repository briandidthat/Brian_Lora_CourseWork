package com.trilogyed.gamestore.dao;

import com.trilogyed.gamestore.model.TShirt;
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
public class TShirtDaoTest {
    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {
        List<TShirt> tShirts = tShirtDao.getAllTShirts();
        for (TShirt t : tShirts) {
            tShirtDao.deleteTShirt(t.getTShirtId());
        }
    }

    @Test
    public void addGetDeleteTShirt() {
        // add
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("20.00"));
        tShirt = tShirtDao.addTShirt(tShirt);
        // get
        TShirt tshirt1 = tShirtDao.getTShirtById(tShirt.getTShirtId());
        assertEquals(tshirt1, tShirt);
        // delete
        tShirtDao.deleteTShirt(tShirt.getTShirtId());
        tshirt1 = tShirtDao.getTShirtById(tShirt.getTShirtId());
        // test for null value to verify deletion
        assertNull(tshirt1);
    }

    @Test
    public void getAllTShirts() {
        // add
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("20.00"));
        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("Large");
        tShirt.setColor("red");
        tShirt.setDescription("new fendi tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("40.00"));
        tShirtDao.addTShirt(tShirt);
        // get all
        List<TShirt> tShirts = tShirtDao.getAllTShirts();
        // verify that only 2 tShirts exist in DB
        assertEquals(2, tShirts.size());
    }

    @Test
    public void getTShirtsBySize() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("20.00"));
        tShirt = tShirtDao.addTShirt(tShirt);
        // get all shirts that are size medium
        List<TShirt> tShirts = tShirtDao.getTShirtsBySize("Medium");
        // verify that there is only one medium as I have only saved one
        assertEquals(1, tShirts.size());
    }

    @Test
    public void getTShirtsByColor() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("20.00"));
        tShirt = tShirtDao.addTShirt(tShirt);
        // get all shirts that are blue
        List<TShirt> tShirts = tShirtDao.getTShirtsByColor("Blue");
        // verify that there is only one red shirt as I have only saved one
        assertEquals(1, tShirts.size());
    }

    @Test
    public void updateTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(4);
        tShirt.setPrice(new BigDecimal("20.00"));
        tShirt = tShirtDao.addTShirt(tShirt);
        // set new values and update DB
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirt.setQuantity(2);
        tShirtDao.updateTShirt(tShirt);
        // get and compare
        TShirt tShirt1 = tShirtDao.getTShirtById(tShirt.getTShirtId());
        assertEquals(tShirt1, tShirt);
    }

    @Test
    public void updateTShirtInventory() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("new gucci tee");
        tShirt.setQuantity(10);
        tShirt.setPrice(new BigDecimal("20.00"));
        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt.setQuantity(4);
        tShirtDao.updateTShirtInventory(tShirt.getTShirtId(), tShirt.getQuantity());

        TShirt tShirt1 = tShirtDao.getTShirtById(tShirt.getTShirtId());
        System.out.println(tShirt.getTShirtId());
        assertEquals(tShirt1, tShirt);
    }
}