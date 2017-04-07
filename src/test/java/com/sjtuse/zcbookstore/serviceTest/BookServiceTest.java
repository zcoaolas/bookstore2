package com.sjtuse.zcbookstore.serviceTest;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.sjtuse.zcbookstore.BaseTest;
import com.sjtuse.zcbookstore.entity.Book;
import com.sjtuse.zcbookstore.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.ExtendedBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zcoaolas on 3/18/2017.
 */
public class BookServiceTest extends BaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testBookList() throws Exception {
        List<Book> bookList = bookService.getAllBooks();
        final Book aBook = bookService.getBook(2);
        Assert.assertNotNull(bookList);
        Assert.assertNotNull(aBook);
        for (Book b : bookList){
            if (b.equals(aBook)) return;
        }
        throw new Exception("testBookList Failed!");
    }
}
