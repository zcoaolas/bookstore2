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

    Book getByBookId (@Param("bookId") Integer bookId);
    List<Book> getAllBooks();
}
