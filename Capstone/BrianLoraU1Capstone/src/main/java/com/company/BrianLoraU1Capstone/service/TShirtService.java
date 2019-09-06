package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.TShirtDao;
import com.company.BrianLoraU1Capstone.model.TShirt;
import com.company.BrianLoraU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TShirtService {
    TShirtDao tShirtDao;

    @Autowired
    public TShirtService(TShirtDao tShirtDao) {
        this.tShirtDao = tShirtDao;
    }

    public TShirtViewModel findTShirtById(int id) {
        TShirt tShirt = tShirtDao.getTShirtById(id);
        if (tShirt == null) {
            return null;
        } else {
            return buildTShirtModel(tShirt);
        }
    }

    public List<TShirtViewModel> findTShirtsByColor(String color) {
        List<TShirt> tShirts = tShirtDao.getTShirtsByColor(color);
        List<TShirtViewModel> tvmList = new ArrayList<>();

        for (TShirt t : tShirts) {
            TShirtViewModel tModel = buildTShirtModel(t);
            tvmList.add(tModel);
        }
        return tvmList;
    }

    public List<TShirtViewModel> findTShirtsBySize(String size) {
        List<TShirt> tShirts = tShirtDao.getTShirtsBySize(size);
        List<TShirtViewModel> tvmList = new ArrayList<>();

        for (TShirt t : tShirts) {
            TShirtViewModel tModel = buildTShirtModel(t);
            tvmList.add(tModel);
        }
        return tvmList;
    }

    public List<TShirtViewModel> findTAllTShirts() {
        List<TShirt> tShirts = tShirtDao.getAllTShirts();
        List<TShirtViewModel> tvmList = new ArrayList<>();

        for (TShirt t : tShirts) {
            TShirtViewModel tModel = buildTShirtModel(t);
            tvmList.add(tModel);
        }
        return tvmList;
    }

    @Transactional
    public TShirtViewModel saveTShirt(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtDao.addTShirt(tShirt);
        tShirtViewModel.setId(tShirt.getTShirtId());

        return tShirtViewModel;
    }

    @Transactional
    public void updateTShirt(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.setTShirtId(tShirtViewModel.getId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirtDao.updateTShirt(tShirt);
    }

    @Transactional
    public void removeShirt(int id) {
        tShirtDao.deleteTShirt(id);
    }

    public TShirtViewModel buildTShirtModel(TShirt tShirt) {
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.setId(tShirt.getTShirtId());
        tShirtViewModel.setSize(tShirt.getSize());
        tShirtViewModel.setColor(tShirt.getColor());
        tShirtViewModel.setDescription(tShirt.getDescription());
        tShirtViewModel.setPrice(tShirt.getPrice());
        tShirtViewModel.setQuantity(tShirt.getQuantity());

        return tShirtViewModel;
    }
}
