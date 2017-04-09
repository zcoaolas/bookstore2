package com.sjtuse.zcbookstore.serviceTest;

import com.sjtuse.zcbookstore.BaseTest;
import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.entity.OrderDetail;
import com.sjtuse.zcbookstore.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zcoaolas on 2017/4/8.
 */
public class OrderServiceTest extends BaseTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void placeOrderTest() throws Exception{
        OrderDetail orderDetail1 = new OrderDetail(0, 1, 3);
        OrderDetail orderDetail2 = new OrderDetail(0, 4, 1);
        List<OrderDetail> orderDetailList = new LinkedList<OrderDetail>();
        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);
        Order order = new Order(0, 2, new BigDecimal(33.33),
                new Timestamp(System.currentTimeMillis()), orderDetailList);

        orderService.placeOrder(order);
    }
}
