package com.company.BrianLoraU1M5Summative.controller;


import com.company.BrianLoraU1M5Summative.dao.AuthorDao;
import com.company.BrianLoraU1M5Summative.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorDao authorDao;

    @PostMapping(value = "/author")
    @ResponseStatus(value = HttpStatus.OK)
    public Author createAuthor(@RequestBody Author author) {
        return authorDao.addAuthor(author);
    }

    @GetMapping(value ="/author")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAuthors() {
        return authorDao.getAuthors();
    }

    @PutMapping(value = "/author")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateAuthor(@RequestBody Author author) {
        authorDao.updateAuthor(author);

    }

    @GetMapping(value = "/author/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Author getAuthor(@PathVariable int id) {
        return authorDao.getAuthor(id);
    }

    @DeleteMapping(value = "/author/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAuthor(int id) {
        authorDao.deleteAuthor(id);
    }


}



