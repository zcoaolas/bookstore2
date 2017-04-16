package com.sjtuse.zcbookstore.serviceImpl;

import com.sjtuse.zcbookstore.dao.BookDao;
import com.sjtuse.zcbookstore.entity.Book;
import com.sjtuse.zcbookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zcoaolas on 3/18/2017.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    @Cacheable(value = "Book")
    public Book getBook(Integer bookId){
        return bookDao.getByBookId(bookId);
    }

    @Override
    @Cacheable(value = "Book", key = "'getAllBooks'")
    public List<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }
}
