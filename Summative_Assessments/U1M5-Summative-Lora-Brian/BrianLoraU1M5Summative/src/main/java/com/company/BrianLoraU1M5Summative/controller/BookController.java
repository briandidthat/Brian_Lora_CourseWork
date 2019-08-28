package com.company.BrianLoraU1M5Summative.controller;

import com.company.BrianLoraU1M5Summative.dao.BookDao;
import com.company.BrianLoraU1M5Summative.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;

    @PostMapping(value = "/book")
    @ResponseStatus(value = HttpStatus.OK)
    public Book createBook(@RequestBody Book book) {
        return bookDao.addBook(book);
    }

    @GetMapping(value = "/books")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> bookList() {
        return bookDao.getBooks();
    }

    @GetMapping(value = "/book/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBookByTitle(@PathVariable String title){
        return bookDao.getBookByTitle(title);
    }
}
