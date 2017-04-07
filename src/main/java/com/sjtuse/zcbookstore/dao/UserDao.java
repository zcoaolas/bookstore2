package com.sjtuse.zcbookstore.dao;

import com.sjtuse.zcbookstore.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcoaolas on 3/5/2017.
 */
@Repository
public interface UserDao {
    /**
     * @param username the name of user
     * @return an User object if username exists, null otherwise
     */
    /* @Param is necessary for mybatis to identify if there are multiple parameters*/
    User getByUsername (@Param("username") String username);

    /**
     *
     * @return List of user entities in the database
     */
    List<User> getAllUsers();
}
