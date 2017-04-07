package com.sjtuse.zcbookstore.web;

import com.sjtuse.zcbookstore.entity.User;
import com.sjtuse.zcbookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by zcoaolas on 3/19/2017.
 */
@Controller
@RequestMapping("/admin") // url:/模块/资源/{id}/
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/adminCenter")
    public String adminCenter(Map<String, Object> map) {
        map.put("users", userService.getAllUsers());
        return "adminCenter";
    }
}