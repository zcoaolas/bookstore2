package com.sjtuse.zcbookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zcoaolas on 2017/4/8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable{
    private Integer orderId;
    private Integer bookId;
    private Integer number;
}