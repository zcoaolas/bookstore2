package com.sjtuse.zcbookstore.service;

import com.sjtuse.zcbookstore.entity.Order;

import javax.jms.Destination;

/**
 * Created by zcoaolas on 2017/4/15.
 */
public interface JMSService {
    void sendOrderMessage(Destination destination, Order orderMessage);
}
