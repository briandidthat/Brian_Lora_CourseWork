package com.company.BrianLoraU1M5Summative.dao;

import com.company.BrianLoraU1M5Summative.model.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    private JdbcTemplate jdbcTemplate;

    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public List<Book> getBooksByAuthor(String firstName, String lastName) {
        return null;
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
    public Book addBook(Book book) {
        return null;
    }

    @Override
    public void deleteBook(int id) {

    }

    // HELPER FUNCTION TO LINK CLASS PROPERTIES TO ENTITY COLUMNS
    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setIsBn(rs.getString("isbn"));
        book.setPublishDate(rs.getDate("publish_date"));
        book.setAuthorId(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPrice(rs.getBigDecimal("price"));

        return book;
    }
}
