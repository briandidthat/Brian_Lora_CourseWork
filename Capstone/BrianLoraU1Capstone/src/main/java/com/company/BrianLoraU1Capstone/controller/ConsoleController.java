package com.company.BrianLoraU1Capstone.controller;

import com.company.BrianLoraU1Capstone.exception.NotFoundException;
import com.company.BrianLoraU1Capstone.service.ConsoleService;
import com.company.BrianLoraU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    ConsoleService consoleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody ConsoleViewModel consoleViewModel) {
        return consoleService.saveConsole(consoleViewModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles() {
        return consoleService.findAllConsoles();
    }

    // ID PATH VARIABLE
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsoleById(@PathVariable("id") int id) {
        ConsoleViewModel console = consoleService.findConsoleById(id);
        if (console == null) {
            throw new NotFoundException("Unfortunately, we do not have a console with that id.");
        }
        return console;
    }

    // MANUFACTURER PATH VARIABLE
    @GetMapping("/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        return consoleService.findConsolesByManufacturer(manufacturer);
    }

}
