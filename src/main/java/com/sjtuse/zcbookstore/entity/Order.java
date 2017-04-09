package com.sjtuse.zcbookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by zcoaolas on 2017/4/1.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private Integer userId;
    private BigDecimal price;
    private Timestamp time;
    private List<OrderDetail> orderDetails;
}
