package com.sjtuse.zcbookstore.daoTest;

import com.sjtuse.zcbookstore.BaseTest;
import com.sjtuse.zcbookstore.dao.UserDao;
import com.sjtuse.zcbookstore.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zcoaolas on 3/5/2017.
 */
public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testUserLogin() throws Exception{
        String username = "tom";
        String password = "tom";
        User u = userDao.getByUsername(username);
        if (u == null)
            System.out.println("Login Failed");
        else
            System.out.println("Login Success");
    }
}
