package com.sjtuse.zcbookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zcoaolas on 3/5/2017.
 */
@Data
@NoArgsConstructor
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private Integer auth;

}
