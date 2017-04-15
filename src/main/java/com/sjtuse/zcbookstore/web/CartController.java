package com.sjtuse.zcbookstore.web;

import com.sjtuse.zcbookstore.entity.Book;
import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.entity.OrderDetail;
import com.sjtuse.zcbookstore.service.CartService;
import com.sjtuse.zcbookstore.service.JMSService;
import com.sjtuse.zcbookstore.service.OrderService;
import javafx.util.Pair;
import org.apache.activemq.command.ActiveMQQueue;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSProducer;
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

    /**
     * Place an order by calling the orderService (traditional way)
     */
    /*@RequestMapping(value = "/submit")
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
    }*/

    /**
     * Place an order using JMS (ActiveMQ)
     */
    @Autowired
    private JMSService producerService;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @RequestMapping(value = "/submit")
    public String sendOrderMessage(HttpSession session){
        //String message = "CZCZCZCZCZCZCZCZ";
        //producerService.sendMessage(destination, message);

        Map<Book, Integer> c = cartService.getCart();
        List<OrderDetail> orderDetails = new LinkedList<>();
        for (Map.Entry<Book, Integer> e : c.entrySet()){
            orderDetails.add(new OrderDetail(0, e.getKey().getBookId(), e.getValue()));
        }
        Order o = new Order(0, (Integer)session.getAttribute("userId"),
                cartService.getTotalPrice(), new Timestamp(System.currentTimeMillis()), orderDetails);
        producerService.sendOrderMessage(destination, o);
        cartService.clearCart();
        return "redirect:/order/showOrder";
    }

}
