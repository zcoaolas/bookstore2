package com.sjtuse.zcbookstore.daoTest;

import com.sjtuse.zcbookstore.BaseTest;
import com.sjtuse.zcbookstore.dao.OrderDao;
import com.sjtuse.zcbookstore.entity.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by zcoaolas on 2017/4/8.
 */
public class OrderDaoTest extends BaseTest{
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testGettingOrders() throws Exception{
        Integer userId = 2;
        List<Order> orderList = orderDao.getOrdersByUser(userId);
        if (orderList == null)
            System.out.println("testGettingOrders Failed");
        else
            System.out.println("testGettingOrders Success");
    }

    @Test
    public void testPlaceOrder() throws Exception{
        Order o = new Order(0, 2, new BigDecimal(33.33),
                new Timestamp(System.currentTimeMillis()), null);
        orderDao.placeOrder(o);
        System.out.println(o.getOrderId());
    }
}
