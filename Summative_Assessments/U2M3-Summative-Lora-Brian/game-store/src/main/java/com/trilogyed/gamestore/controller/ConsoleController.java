package com.trilogyed.gamestore.controller;

import com.trilogyed.gamestore.exception.NotFoundException;
import com.trilogyed.gamestore.model.Console;
import com.trilogyed.gamestore.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/gamestore/consoles")
public class ConsoleController {
    @Autowired
    ConsoleService consoleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(Principal principal, @RequestBody @Valid Console console) {
        return consoleService.saveConsole(console);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsoles() {
        return consoleService.findAllConsoles();
    }

    // ID PATH VARIABLE
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById(@PathVariable("id") int id) {
        Console console = consoleService.findConsoleById(id);
        if (console == null) {
            throw new NotFoundException("Unfortunately, we do not have a console with the id: " + id + ".");
        }
        return console;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(Principal principal, @PathVariable("id") int id, @RequestBody @Valid Console console) {
        if (console.getConsoleId() == 0) {
            console.setConsoleId(id);
        }
        if (id != console.getConsoleId()) {
            throw new IllegalArgumentException("Console ID on path must match the ID in the console object");
        }
        consoleService.updateConsole(console);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(Principal principal, @PathVariable("id") int id) {
        consoleService.removeConsole(id);
    }

    // MANUFACTURER PATH VARIABLE
    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<Console> consoles = consoleService.findConsolesByManufacturer(manufacturer);
        if (consoles == null) {
            throw new NotFoundException("Unfortunately, we could not find any consoles by the manufacturer: " +
                    manufacturer + ".");
        }
        return consoles;
    }
}
