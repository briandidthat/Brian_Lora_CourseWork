package com.trilogyed.gamestore.dao;

import com.trilogyed.gamestore.model.TShirt;

import java.util.List;


public interface TShirtDao {
    TShirt addTShirt(TShirt tShirt);
    TShirt getTShirtById(int id);

    List<TShirt> getAllTShirts();
    List<TShirt> getTShirtsBySize(String size);
    List<TShirt> getTShirtsByColor(String color);

    void updateTShirtInventory(int id, int quantity);
    void updateTShirt(TShirt tShirt);
    void deleteTShirt(int id);
}
