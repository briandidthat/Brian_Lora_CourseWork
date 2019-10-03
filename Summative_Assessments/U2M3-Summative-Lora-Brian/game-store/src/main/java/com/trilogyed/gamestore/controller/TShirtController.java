package com.trilogyed.gamestore.controller;

import com.trilogyed.gamestore.exception.NotFoundException;
import com.trilogyed.gamestore.model.TShirt;
import com.trilogyed.gamestore.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/gamestore/tshirts")
public class TShirtController {
    @Autowired
    TShirtService tShirtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt createTShirt(Principal principal, @RequestBody @Valid TShirt tShirt) {
        return tShirtService.saveTShirt(tShirt);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getAllTShirts() {
        return tShirtService.findTAllTShirts();
    }

    // ID PATH VARIABLE
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirt getTShirt(@PathVariable("id") int id) {
        TShirt tShirt = tShirtService.findTShirtById(id);
        if (tShirt == null) {
            throw new NotFoundException("Unfortunately, we don't have a t-shirt with the id: " + id + ".");
        }
        return tShirt;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(Principal principal, @PathVariable("id") int id, @RequestBody @Valid TShirt tShirt) {
        if (tShirt.getTShirtId() == 0) {
            tShirt.setTShirtId(id);
        }
        if (id != tShirt.getTShirtId()) {
            throw new IllegalArgumentException("T-Shirt ID on path must match the ID in the t-shirt object.");
        }
        tShirtService.updateTShirt(tShirt);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(Principal principal, @PathVariable("id") int id) {
        tShirtService.removeShirt(id);
    }

    // COLOR PATH VARIABLE
    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtsByColor(@PathVariable("color") String color) {
        List<TShirt> tShirts = tShirtService.findTShirtsByColor(color);
        if (tShirts == null) {
            throw new NotFoundException("Unfortunately, we could not find any t-shirts of the color: " + color + ".");
        }
        return tShirts;
    }

    // SIZE PATH VARIABLE
    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtsBySize(@PathVariable("size") String size) {
        List<TShirt> tShirts = tShirtService.findTShirtsBySize(size);
        if (tShirts == null) {
            throw new NotFoundException("Unfortunately, we could not find any t-shirts of size: " + size + ".");
        }
        return tShirts;
    }
}
