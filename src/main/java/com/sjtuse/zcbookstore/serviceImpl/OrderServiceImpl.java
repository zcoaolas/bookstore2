package com.sjtuse.zcbookstore.serviceImpl;

import com.sjtuse.zcbookstore.dao.OrderDao;
import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.entity.OrderDetail;
import com.sjtuse.zcbookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zcoaolas on 2017/4/8.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    public void placeOrder(Order order){
        orderDao.placeOrder(order);

        final Integer oId = order.getOrderId();
        List<OrderDetail> oDetails= order.getOrderDetails();
        oDetails.forEach(od -> od.setOrderId(oId));
        orderDao.addOrderDetails(oDetails);
    }

    public List<Order> getOrdersByUser (Integer userId){
        return orderDao.getOrdersByUser(userId);
    }
}
