package com.sjtuse.zcbookstore.service;

import com.sjtuse.zcbookstore.entity.Order;

import java.util.List;

/**
 * Created by zcoaolas on 2017/4/8.
 */
public interface OrderService {

    /**
     * The user submit an order
     * @param order to be written into database
     */
    void placeOrder(Order order);

    /**
     *
     * @param userId indicates a particular user
     * @return a list of all orders this user placed
     */
    List<Order> getOrdersByUser (Integer userId);
}
