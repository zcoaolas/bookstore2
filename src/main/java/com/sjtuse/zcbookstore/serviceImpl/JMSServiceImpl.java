package com.sjtuse.zcbookstore.serviceImpl;

/**
 * Created by zcoaolas on 2017/4/15.
 */

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import com.sjtuse.zcbookstore.entity.Order;
import com.sjtuse.zcbookstore.service.JMSService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JMSServiceImpl implements JMSService {

    @Resource
    private JmsTemplate jmsTemplate;

    public void sendOrderMessage(Destination destination, final Order orderMessage) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createObjectMessage(orderMessage);
                return message;
                //return session.createTextMessage(message);
            }
        });
    }

}