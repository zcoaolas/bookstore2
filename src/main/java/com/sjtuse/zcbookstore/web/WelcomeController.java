package com.sjtuse.zcbookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zcoaolas on 3/16/2017.
 */
@Controller
//@RequestMapping("/") // url:/模块/资源/{id}/
public class WelcomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userLogin() {
        return "index";
    }

    @RequestMapping(value = "/chat")
    public String chatRoom() {
        return "websocket";
    }
}
