package com.sjtuse.zcbookstore.web;

import com.sjtuse.zcbookstore.entity.Book;
import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.entity.OrderDetail;
import com.sjtuse.zcbookstore.service.CartService;
import com.sjtuse.zcbookstore.service.OrderService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/cartList")
    public String cartList(Map<String, Object> map){
        Map<Book, Integer> c = cartService.getCart();
        List<Pair<Book, Integer>> lst = new LinkedList<>();
        Pair<Book, Integer> p;
        for (Map.Entry<Book, Integer> e : c.entrySet()){
            p = new Pair<>(e.getKey(), e.getValue());
            lst.add(p);
        }
        map.put("cart", lst);
        map.put("total", cartService.getTotalPrice().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        return "shoppingCart";
    }

    @RequestMapping(value = "/pay")
    public String cartPay(){
        return "shoppingOrder";
    }

    @RequestMapping(value = "/submit")
    public String submit(HttpSession session) {
        Map<Book, Integer> c = cartService.getCart();
        List<OrderDetail> orderDetails = new LinkedList<>();
        for (Map.Entry<Book, Integer> e : c.entrySet()){
            orderDetails.add(new OrderDetail(0, e.getKey().getBookId(), e.getValue()));
        }
        orderService.placeOrder(new Order(0, (Integer)session.getAttribute("userId"),
                cartService.getTotalPrice(), new Timestamp(System.currentTimeMillis()), orderDetails));
        cartService.clearCart();
        return "redirect:/order/showOrder";
    }
}
