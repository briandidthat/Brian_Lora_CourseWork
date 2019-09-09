package com.company.BrianLoraU1Capstone.controller;

import com.company.BrianLoraU1Capstone.exception.NotFoundException;
import com.company.BrianLoraU1Capstone.service.ConsoleService;
import com.company.BrianLoraU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    ConsoleService consoleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
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
            throw new NotFoundException("Unfortunately, we do not have a console with the id: " + id + ".");
        }
        return console;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int id, @RequestBody @Valid ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getId() == 0) {
            consoleViewModel.setId(id);
        }
        if (id != consoleViewModel.getId()) {
            throw new IllegalArgumentException("Console ID on path must match the ID in the console object");
        }
        consoleService.updateConsole(consoleViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int id) {
        consoleService.removeConsole(id);
    }

    // MANUFACTURER PATH VARIABLE
    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<ConsoleViewModel> consoles = consoleService.findConsolesByManufacturer(manufacturer);
        if (consoles != null && consoles.size() == 0) {
            throw new NotFoundException("Unfortunately, we could not find any consoles by the manufacturer: " +
                    manufacturer + ".");
        }
        return consoles;
    }

}
