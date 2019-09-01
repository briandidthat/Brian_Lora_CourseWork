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
public class PublisherDaoTest {
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;

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
    public void addGetDeletePublisher() {
        // ADD PUBLISHER
        Publisher publisher = new Publisher();
        publisher.setName("Motown Books");
        publisher.setStreet("1012 broadway");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("90201");
        publisher.setPhone("212-244-2232");
        publisher.setEmail("moTown@Gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        // GET PUBLISHER
        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());
        // TEST RETURNED PUBLISHER FOR EQUALITY
        assertEquals(publisher1, publisher);

        // DELETE PUBLISHER
       publisherDao.deletePublisher(publisher.getPublisherId());
       publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

       assertNull(publisher1);
    }

    @Test
    public void getAllPublishers() {
        // ADD PUBLISHER
        Publisher publisher = new Publisher();
        publisher.setName("Motown Books");
        publisher.setStreet("1012 broadway");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("90201");
        publisher.setPhone("212-244-2232");
        publisher.setEmail("moTown@Gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        publisherDao.addPublisher(publisher1);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(publisherList.size(), 2);

    }

    @Test
    public void updatePublisher() {
    }

}