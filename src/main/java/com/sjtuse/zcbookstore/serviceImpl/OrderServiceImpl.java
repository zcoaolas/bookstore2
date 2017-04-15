package com.sjtuse.zcbookstore.serviceImpl;

import com.sjtuse.zcbookstore.dao.OrderDao;
import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.entity.OrderDetail;
import com.sjtuse.zcbookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zcoaolas on 2017/4/8.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    /*
    需要在事务中执行，保证下单动作有意义
    需要Serializable，否则订单的ID会写错（不可接受）
     */
    @Transactional(propagation= Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void placeOrder(Order order){
        orderDao.placeOrder(order);

        final Integer oId = order.getOrderId();
        List<OrderDetail> oDetails= order.getOrderDetails();
        oDetails.forEach(od -> od.setOrderId(oId));
        orderDao.addOrderDetails(oDetails);
    }

    /*
    因为是只读，可以不在事务下执行
    查订单的动作和用户相关，READ_COMMITTED保证相对的可靠性又不损失很多性能
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<Order> getOrdersByUser (Integer userId){
        return orderDao.getOrdersByUser(userId);
    }
}
