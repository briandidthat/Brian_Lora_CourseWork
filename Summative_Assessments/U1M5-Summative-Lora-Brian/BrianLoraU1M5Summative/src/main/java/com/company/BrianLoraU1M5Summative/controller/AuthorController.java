package com.company.BrianLoraU1M5Summative.controller;

import com.company.BrianLoraU1M5Summative.dao.AuthorDao;
import com.company.BrianLoraU1M5Summative.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorDao authorDao;

    @GetMapping(value ="/authors")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAuthors() {
        return authorDao.getAuthors();
    }

    @PostMapping(value = "/author")
    @ResponseStatus(value = HttpStatus.OK)
    public Author createAuthor(@RequestBody Author author) {
        return authorDao.addAuthor(author);
    }
}
