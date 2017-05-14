package com.sjtuse.zcbookstore.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by zcoaolas on 2017/5/13.
 */
@WebService
public interface BookService2 {
    @WebMethod
    public String getBookInfo (String bookId);
}
