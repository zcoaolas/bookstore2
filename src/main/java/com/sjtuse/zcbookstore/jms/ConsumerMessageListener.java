package com.sjtuse.zcbookstore.jms;

/**
 * Created by zcoaolas on 2017/4/15.
 */

import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;

public class ConsumerMessageListener implements MessageListener {
    @Autowired
    private OrderService orderService;

    public void onMessage(Message message) {
        /*TextMessage textMsg = (TextMessage) message;
        try {
            System.out.println("接收者受到消息：" + textMsg.getText());
            System.out.println("开始进行解析并调用service执行....");

        } catch (JMSException e) {
            e.printStackTrace();
        }*/
        if (message instanceof ObjectMessage) {
            ObjectMessage objMsg = (ObjectMessage) message;
            try {
                Order order = (Order) objMsg.getObject();
                //System.out.println(order.toString());
                orderService.placeOrder(order);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Message Consumer: Not supported message type.");
        }
    }

}