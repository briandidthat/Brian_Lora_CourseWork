package com.company.BrianLoraU1M5Summative.dao;

import com.company.BrianLoraU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getAuthors();
    Author getAuthor(int id);
    Author addAuthor(Author author);

    void deleteAuthor(int id);
    void updateAuthor(Author author);
}
