package com.sjtuse.zcbookstore.service;

import com.sjtuse.zcbookstore.entity.Book;

import java.util.List;

/**
 * Created by zcoaolas on 3/18/2017.
 */
public interface BookService {
    /**
     * Get all info about book by its id
     * @param bookId the id of which book you want to search
     * @return the book entity
     */
    Book getBook(Integer bookId);

    /**
     * TODO: divide into pages
     * @return the list of all books
     */
    List<Book> getAllBooks();
}
