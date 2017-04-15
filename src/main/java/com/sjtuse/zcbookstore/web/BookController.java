package com.sjtuse.zcbookstore.web;

import com.sjtuse.zcbookstore.entity.Book;
import com.sjtuse.zcbookstore.service.BookService;
import com.sjtuse.zcbookstore.service.CartService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zcoaolas on 3/18/2017.
 */
@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public String bookList(Map<String, Object> map){

        List<Book> bookList = bookService.getAllBooks();
        /*
         * Filter categories of books according to user Auth.
         */
        Subject userSubj = SecurityUtils.getSubject();
        Map<String, List<String>> categoryPerm = new HashMap<String, List<String>>();
        // User
        List<String> ls = new LinkedList<String>();
        ls.add("Literature");
        categoryPerm.put("user", ls);
        // Admin
        ls = new LinkedList<String>();
        ls.add("Literature");
        ls.add("Science");
        categoryPerm.put("admin", ls);

        List<String> yourCategories = new LinkedList<String>();
        if (userSubj.hasRole("user")) {
            yourCategories = categoryPerm.get("user");
        }
        else if (userSubj.hasRole("admin")){
            yourCategories = categoryPerm.get("admin");
        }
        List<Book> filteredBooks = new LinkedList<Book>();
        for (Book book : bookList){
            String [] ca = book.getCategory().split("/");
            if(ca.length > 0 && yourCategories.contains(ca[0])){
                filteredBooks.add(book);
            }
        }
        map.put("books", filteredBooks);
        return "bookList";
    }

    @RequestMapping(value = "/bookAddCart")
    public String bookAddCart(@RequestParam(value = "amount") Integer amount,
                              @RequestParam(value = "id") Integer bookId){
        Book b = bookService.getBook(bookId);
        cartService.addToCart(b, amount);
        //map.put("info", "Ordered successfully");
        return "redirect:/cart/cartList";
    }

    @RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
    public String bookDetail(@RequestParam(value = "id") Integer bookId,
                             Map<String, Object> map, HttpSession session){
        List<Book> lb = new LinkedList<Book>();
        Book b = bookService.getBook(bookId);
        lb.add(b);
        map.put("book", lb);
        map.put("bookId", b.getBookId());
        //session.setAttribute("bookId", b.getBookId());
        return "bookDetail";
    }

    @RequestMapping(value="/bookDetail/{bookId}", method = RequestMethod.GET, produces="application/json; charset=utf-8")
    @ResponseBody
    public JSONObject bookInfo(@PathVariable("bookId") Integer bookId) {
        JSONObject json = new JSONObject();
        Book book = bookService.getBook(bookId);
        json.put("bookId", book.getBookId());
        json.put("bookName", book.getBookName());
        json.put("bookInfo", book.getBookInfo());
        json.put("bookAuthor", book.getBookAuthor());
        json.put("bookCategory", book.getCategory());
        json.put("bookPrice", book.getBookPrice());
        return json;
    }

}
