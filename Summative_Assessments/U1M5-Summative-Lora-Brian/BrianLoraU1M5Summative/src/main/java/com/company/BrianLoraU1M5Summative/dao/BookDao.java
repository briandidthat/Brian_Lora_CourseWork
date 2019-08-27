package com.company.BrianLoraU1M5Summative.dao;

import com.company.BrianLoraU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBooks();
    List<Book> getBooksByAuthor(int author_id);

    Book getBookByTitle(String title);
    Book addBook(Book book);

    void deleteBook(int id);
    void updateBook(Book book);
}
