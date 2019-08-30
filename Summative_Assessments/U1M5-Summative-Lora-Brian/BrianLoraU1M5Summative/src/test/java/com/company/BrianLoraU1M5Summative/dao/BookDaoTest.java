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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

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
    public void addGetDeleteBook() {
        // MUST ADD AUTHOR FIRST
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("Hawkings");
        author.setStreet("1102 broadway");
        author.setCity("NYC");
        author.setState("NY");
        author.setPostalCode("10040");
        author.setPhone("212-345-5432");
        author.setEmail("stephawkings@gmail.com");
        author = authorDao.addAuthor(author);

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

        // CREATE BOOK
        Book book = new Book();
        book.setIsBn("12134asdds");
        book.setPublishDate(LocalDate.of(1992,11,22));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Charlottes Web");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("20.99"));
        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getBookId());
        // CHECK THAT THE ENTERED BOOK AND COPIED BOOK ARE "EQUAL"
        assertEquals(book1, book);

        // DELETE BOOK
        bookDao.deleteBook(book.getBookId());

        book1 = bookDao.getBook(book.getBookId());

        assertNull(book1);

    }

    @Test
    public void getAllBooks() {
        // MUST ADD AUTHOR FIRST
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("Hawkings");
        author.setStreet("1102 broadway");
        author.setCity("NYC");
        author.setState("NY");
        author.setPostalCode("10040");
        author.setPhone("212-345-5432");
        author.setEmail("stephawkings@gmail.com");
        author = authorDao.addAuthor(author);

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

        // CREATE BOOK
        Book book = new Book();
        book.setIsBn("12134asdds");
        book.setPublishDate(LocalDate.of(1992,11,22));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Charlottes Web");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("20.99"));
        book = bookDao.addBook(book);

        Book book1 = new Book();
        book1.setIsBn("2345aesdre");
        book1.setPublishDate(LocalDate.of(2001,11,22));
        book1.setAuthorId(author.getAuthorId());
        book1.setTitle("Holes");
        book1.setPublisherId(publisher.getPublisherId());
        book1.setPrice(new BigDecimal("30.99"));
        book1 = bookDao.addBook(book);

        List<Book> bookList = bookDao.getBooks();

        assertEquals(bookList.size(), 2);
    }

    @Test
    public void updateBook() {
    }
}