package com.company.BrianLoraU1M5Summative.dao;

import com.company.BrianLoraU1M5Summative.model.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {

    // PREPARED STATEMENTS
    private static final String INSERT_BOOK_SQL =
            "insert into book (isBn, date, author_id, title, publisher_id, price) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BOOK_SQL =
            "select * from book where book_id = ?";

    private static final String SELECT_ALL_BOOKS_SQL =
            "select * from book";

    private static final String DELETE_BOOK_SQL =
            "delete form car where book_id = ?";

    private static final String SELECT_BOOK_BY_TITLE_SQL =
            "select * from book where title = ?";

    private static final String SELECT_BOOK_BY_PUBLISHER_SQL =
            "select * from book where title = ?";

    private JdbcTemplate jdbcTemplate;

    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public List<Book> getBooksByAuthor(int authorId) {
        return null;
    }

    @Override
    public List<Book> getBooksByPublisher(int publisherId) {
        return jdbcTemplate.query(SELECT_BOOK_BY_PUBLISHER_SQL, this::mapRowToBook, publisherId);
    }

    @Override
    public Book getBookByTitle(String title) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOK_BY_TITLE_SQL, this::mapRowToBook, title);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsBn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        book.setBookId(id);

        return book;
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsBn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getBookId());
    }

    // HELPER FUNCTION TO LINK CLASS PROPERTIES TO ENTITY COLUMNS
    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setIsBn(rs.getString("isbn"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setAuthorId(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPrice(rs.getBigDecimal("price"));

        return book;
    }
}
