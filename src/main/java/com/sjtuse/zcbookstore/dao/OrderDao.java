package com.sjtuse.zcbookstore.dao;

import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.entity.OrderDetail;
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
     * The auto-generated userId will be set into this order object by MyBatis
     * @param order a submitted cart
     */
    void placeOrder(Order order);
    /**
     * Should always be done right after the placeOrder function!!!
     * @param orderDetails an orderDetail list
     */
    void addOrderDetails(List<OrderDetail> orderDetails);

    /**
     * @param userId the user id
     * @return all orders this user placed
     */
    List<Order> getOrdersByUser(Integer userId);
}
