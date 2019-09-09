package com.company.BrianLoraU1Capstone.controller;

import com.company.BrianLoraU1Capstone.exception.NotFoundException;
import com.company.BrianLoraU1Capstone.service.TShirtService;
import com.company.BrianLoraU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tshirt")
public class TShirtController {

    @Autowired
    TShirtService tShirtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel createTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel) {
        return tShirtService.saveTShirt(tShirtViewModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getAllTShirts() {
        return tShirtService.findTAllTShirts();
    }

    // ID PATH VARIABLE
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") int id) {
        TShirtViewModel tShirtViewModel = tShirtService.findTShirtById(id);
        if (tShirtViewModel == null) {
            throw new NotFoundException("Unfortunately, we don't have a t-shirt with the id: " + id + ".");
        }
        return tShirtViewModel;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("id") int id, @RequestBody @Valid TShirtViewModel tShirtViewModel) {
        if (tShirtViewModel.getId() == 0) {
            tShirtViewModel.setId(id);
        }
        if (id != tShirtViewModel.getId()) {
            throw new IllegalArgumentException("T-Shirt ID on path must match the ID in the t-shirt object.");
        }
        tShirtService.updateTShirt(tShirtViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int id) {
        tShirtService.removeShirt(id);
    }

    // COLOR PATH VARIABLE
    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsByColor(@PathVariable("color") String color) {
        List<TShirtViewModel> tShirts = tShirtService.findTShirtsByColor(color);
        if (tShirts != null && tShirts.size() == 0) {
            throw new NotFoundException("Unfortunately, we could not find any t-shirts of the color: " + color + ".");
        }
        return tShirts;
    }

    // SIZE PATH VARIABLE
    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable("size") String size) {
        List<TShirtViewModel> tShirts = tShirtService.findTShirtsBySize(size);
        if (tShirts != null && tShirts.size() == 0) {
            throw new NotFoundException("Unfortunately, we could not find any t-shirts of size: " + size + ".");
        }
        return tShirts;
    }

}
