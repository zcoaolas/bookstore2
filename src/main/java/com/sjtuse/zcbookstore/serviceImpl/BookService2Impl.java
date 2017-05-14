package com.sjtuse.zcbookstore.serviceImpl;

import com.sjtuse.zcbookstore.dao.BookDao;
import com.sjtuse.zcbookstore.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * Created by zcoaolas on 2017/5/13.
 */
@Component
@WebService(serviceName = "bookservice", endpointInterface = "com.sjtuse.zcbookstore.service.BookService2")
public class BookService2Impl implements BookService2 {
    @Autowired
    private BookDao bookDao;

    @Override
    public String getBookInfo(String bookId){
        return bookDao.getByBookId(Integer.parseInt(bookId)).toString();
    }

}
