package com.company.BrianLoraU1M5Summative.controller;

import com.company.BrianLoraU1M5Summative.dao.AuthorDao;
import com.company.BrianLoraU1M5Summative.dao.BookDao;
import com.company.BrianLoraU1M5Summative.model.Author;
import com.company.BrianLoraU1M5Summative.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;

    @PostMapping(value = "/book")
    @ResponseStatus(value = HttpStatus.OK)
    public Book createBook(@RequestBody Book book) {
        return bookDao.addBook(book);
    }

    @GetMapping(value = "/book")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookDao.getBooks();
    }

    @PutMapping(value = "/book")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateBook(@RequestBody Book book) {
        bookDao.updateBook(book);
    }

    @GetMapping(value = "/book/{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Book getBook(@PathVariable int id) {
        return bookDao.getBook(id);
    }

    @DeleteMapping(value="/book/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBook(@PathVariable int id) {
        bookDao.deleteBook(id);
    }

    @GetMapping(value = "/book/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBookByTitle(@PathVariable String title){
        return bookDao.getBookByTitle(title);
    }


    @GetMapping(value = "/book/author/{authorId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable int authorId) {
        Author author = authorDao.getAuthor(authorId);

        return bookDao.getBooksByAuthor(author.getAuthorId());
    }

}
