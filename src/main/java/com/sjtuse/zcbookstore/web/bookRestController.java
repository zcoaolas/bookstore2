package com.sjtuse.zcbookstore.web;

import com.sjtuse.zcbookstore.service.BookService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcoaolas on 2017/5/12.
 */
@RestController
public class bookRestController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/rest/book/{bookId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity<JSONObject> getBookById(@PathVariable("bookId") Integer bookId) {
        JSONObject bk = JSONObject.fromObject(bookService.getBook(bookId));
        return new ResponseEntity<>(bk, HttpStatus.OK);
    }
}