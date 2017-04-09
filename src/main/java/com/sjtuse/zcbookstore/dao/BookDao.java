package com.sjtuse.zcbookstore.dao;

import com.sjtuse.zcbookstore.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcoaolas on 3/18/2017.
 */
@Repository
public interface BookDao {

    /**
     * Query a single book
     * @param bookId an Integer
     * @return the book of this Id, null if not exists
     */
    Book getByBookId (@Param("bookId") Integer bookId);

    /**
     * List all books in the database
     * @return a book list
     */
    List<Book> getAllBooks();
}
