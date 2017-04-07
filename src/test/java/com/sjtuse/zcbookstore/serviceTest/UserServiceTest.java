package com.sjtuse.zcbookstore.serviceTest;

import com.sjtuse.zcbookstore.BaseTest;
import com.sjtuse.zcbookstore.entity.User;
import com.sjtuse.zcbookstore.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zcoaolas on 3/5/2017.
 */
public class UserServiceTest extends BaseTest{

    @Autowired
    private UserService userService;

    @Test
    public void testUserLogin() throws Exception {
        String username = "floyd";
        String password = "floydpwd";
        User u = userService.getByUsername(username);
        if (u == null)
            System.out.println("Login Failed");
        else
            System.out.println("Login Success");
    }
}
