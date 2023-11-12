package ca.sheridancollege.elzeind.Assignment_2.Database;

import ca.sheridancollege.elzeind.Assignment_2.beans.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseAccess.class);

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public boolean insertBook(Book book) {
        try {
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            String query = "INSERT INTO books (title, author, isbn, price, description) VALUES (:title, :author, :isbn, :price, :description)";
            namedParameters.addValue("title", book.getTitle());
            namedParameters.addValue("author", book.getAuthor());
            namedParameters.addValue("isbn", book.getIsbn());
            namedParameters.addValue("price", book.getPrice());
            namedParameters.addValue("description", book.getDescription());
            return jdbc.update(query, namedParameters) > 0;
        } catch (Exception e) {
            logger.error("Error inserting book: ", e);
            return false;
        }
    }

    public List<Book> getBookList() {
        try {
            MapSqlParameterSource namedParameter = new MapSqlParameterSource();
            String query = "SELECT * FROM books";
            return jdbc.query(query, namedParameter, new BeanPropertyRowMapper<>(Book.class));
        } catch (Exception e) {
            logger.error("Error retrieving book list: ", e);
            return null;
        }
    }

    public boolean updateBook(Book updatedBook) {
        try {
            MapSqlParameterSource namedParameter = new MapSqlParameterSource();
            String query = "UPDATE books SET title = :title, author = :author, isbn = :isbn, price = :price, description = :description WHERE id = :id";
            namedParameter.addValue("title", updatedBook.getTitle());
            namedParameter.addValue("author", updatedBook.getAuthor());
            namedParameter.addValue("isbn", updatedBook.getIsbn());
            namedParameter.addValue("price", updatedBook.getPrice());
            namedParameter.addValue("description", updatedBook.getDescription());
            namedParameter.addValue("id", updatedBook.getId());
            return jdbc.update(query, namedParameter) > 0;
        } catch (Exception e) {
            logger.error("Error updating book: ", e);
            return false;
        }
    }

    public boolean deleteBookById(Long id) {
        try {
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            String query = "DELETE from books WHERE id = :id";
            namedParameters.addValue("id", id);
            return jdbc.update(query, namedParameters) > 0;
        } catch (Exception e) {
            logger.error("Error deleting book: ", e);
            return false;
        }
    }

    public List<Book> getBookById(Long id) {
        try {
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            String query = "SELECT * FROM books WHERE id = :id";
            namedParameters.addValue("id", id);
            return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Book.class));
        } catch (Exception e) {
            logger.error("Error retrieving book by id: ", e);
            return null;
        }
    }
}
