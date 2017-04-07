package com.sjtuse.zcbookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by zcoaolas on 2017/3/26.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(value = "/showOrder")
    public String orderList(Map<String, Object> map){
        return "shoppingOrder";
    }

}
