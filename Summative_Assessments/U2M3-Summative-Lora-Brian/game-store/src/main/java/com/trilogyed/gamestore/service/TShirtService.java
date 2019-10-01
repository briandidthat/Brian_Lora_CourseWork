package com.trilogyed.gamestore.service;

import com.trilogyed.gamestore.dao.TShirtDao;
import com.trilogyed.gamestore.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class TShirtService {
    TShirtDao tShirtDao;

    @Autowired
    public TShirtService(TShirtDao tShirtDao) {
        this.tShirtDao = tShirtDao;
    }

    public TShirt findTShirtById(int id) {
        TShirt tShirt = tShirtDao.getTShirtById(id);
        if (tShirt == null) {
            return null;
        }
        return tShirt;
    }

    public List<TShirt> findTShirtsByColor(String color) {
        List<TShirt> tShirts = tShirtDao.getTShirtsByColor(color);
        if (tShirts == null) {
            return null;
        }
        return tShirts;
    }

    public List<TShirt> findTShirtsBySize(String size) {
        List<TShirt> tShirts = tShirtDao.getTShirtsBySize(size);
        if (tShirts == null) {
            return null;
        }
        return tShirts;
    }

    public List<TShirt> findTAllTShirts() {
        return tShirtDao.getAllTShirts();
    }

    @Transactional
    public TShirt saveTShirt(TShirt tShirt) {
        return tShirtDao.addTShirt(tShirt);
    }

    public void updateTShirt(TShirt tShirt) {
        tShirtDao.updateTShirt(tShirt);
    }

    public void removeShirt(int id) {
        tShirtDao.deleteTShirt(id);
    }
}
