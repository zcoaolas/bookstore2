package com.sjtuse.zcbookstore.dao;

import com.sjtuse.zcbookstore.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zcoaolas on 2017/4/1.
 */
@Repository
public interface OrderDao {
    /**
     * @param order a submitted cart
     */
    void placeOrder(Order order);

    /**
     * @param userId the user id
     * @return all orders this user placed
     */
    List<Order> getOrdersByUser(Integer userId);
}
