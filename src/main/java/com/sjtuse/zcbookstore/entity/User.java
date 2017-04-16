package com.sjtuse.zcbookstore.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zcoaolas on 3/5/2017.
 */
@Data
@NoArgsConstructor
@JsonSerialize
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class User implements Serializable{
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private Integer auth;

}
