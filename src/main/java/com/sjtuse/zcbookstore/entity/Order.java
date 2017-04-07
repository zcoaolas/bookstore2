package com.sjtuse.zcbookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;

/**
 * Created by zcoaolas on 2017/4/1.
 */
@Data
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private Integer userId;
    private BigDecimal price;
    private Date time;
    private HashMap<Book, Integer> order;
}
