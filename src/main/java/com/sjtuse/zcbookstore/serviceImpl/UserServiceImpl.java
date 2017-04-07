package com.sjtuse.zcbookstore.serviceImpl;

import com.sjtuse.zcbookstore.dao.UserDao;
import com.sjtuse.zcbookstore.entity.User;
import com.sjtuse.zcbookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zcoaolas on 3/5/2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    public User getByUsername(String username){
        return userDao.getByUsername(username);
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}
