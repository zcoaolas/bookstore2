package com.sjtuse.zcbookstore.web;

import com.sjtuse.zcbookstore.entity.Book;
import com.sjtuse.zcbookstore.service.CartService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zcoaolas on 3/18/2017.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cartList")
    public String cartList(Map<String, Object> map){
        Map<Book, Integer> c = cartService.getCart();
        List<Pair<Book, Integer>> lst = new LinkedList<Pair<Book, Integer>>();
        Pair<Book, Integer> p;
        BigDecimal totalC = new BigDecimal(0);
        for (Map.Entry<Book, Integer> e : c.entrySet()){
            p = new Pair<Book, Integer>(e.getKey(), e.getValue());
            totalC = totalC.add(e.getKey().getBookPrice().multiply(BigDecimal.valueOf(e.getValue())));
            lst.add(p);
        }
        map.put("cart", lst);
        map.put("total", totalC.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        return "shoppingCart";
    }

    @RequestMapping(value = "/pay")
    public String cartPay(){
        return "shoppingOrder";
    }
}
