package com.company.BrianLoraU1M5Summative.dao;

import com.company.BrianLoraU1M5Summative.model.Author;
import com.company.BrianLoraU1M5Summative.model.Book;
import com.company.BrianLoraU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        // clear book db
        List<Book> bookList = bookDao.getBooks();
        for (Book b : bookList) {
            bookDao.deleteBook(b.getBookId());
        }
        // clear author db
        List<Author> authorList = authorDao.getAuthors();
        for (Author a : authorList) {
            authorDao.deleteAuthor(a.getAuthorId());
        }


        // clear publisher db
        List<Publisher> publisherList = publisherDao.getAllPublishers();
        for (Publisher p : publisherList) {
            publisherDao.deletePublisher(p.getPublisherId());
        }
    }

    @Test
    public void addGetDeleteAuthor() {
        // TESTING ADD METHOD
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("Hawkings");
        author.setStreet("1102 broadway");
        author.setCity("NYC");
        author.setState("NY");
        author.setPostalCode("10040");
        author.setPhone("212-345-5432");
        author.setEmail("stephawkings@gmail.com");
        authorDao.addAuthor(author);


        // TESTING GET METHOD
        Author author1 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author, author1);

        // TESTING DELETE METHOD
        authorDao.deleteAuthor(author.getAuthorId());
        author1 = authorDao.getAuthor(author.getAuthorId());

        assertNull(author1);

    }

    @Test
    public void getAuthors() {
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("Hawkings");
        author.setStreet("1102 broadway");
        author.setCity("NYC");
        author.setState("NY");
        author.setPostalCode("10040");
        author.setPhone("212-345-5432");
        author.setEmail("stephawkings@gmail.com");
        authorDao.addAuthor(author);

        Author author1 = new Author();
        author1.setFirstName("Stephen");
        author1.setLastName("Hawkings");
        author1.setStreet("1102 broadway");
        author1.setCity("NYC");
        author1.setState("NY");
        author1.setPostalCode("10040");
        author1.setPhone("212-345-5432");
        author1.setEmail("stephawkings@gmail.com");
        authorDao.addAuthor(author1);

        List<Author> authorList = authorDao.getAuthors();

        assertEquals(authorList.size(), 2);

    }

    @Test
    public void updateAuthor() {
    }
}