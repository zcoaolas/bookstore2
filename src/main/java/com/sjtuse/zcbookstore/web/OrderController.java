package com.sjtuse.zcbookstore.web;

import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.service.CartService;
import com.sjtuse.zcbookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by zcoaolas on 2017/3/26.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/showOrder")
    public String orderList(HttpSession session, Map<String, Object> map){
        List<Order> orderList = orderService.getOrdersByUser((Integer)session.getAttribute("userId"));
        map.put("orders", orderList);
        return "shoppingOrder";
    }

}
