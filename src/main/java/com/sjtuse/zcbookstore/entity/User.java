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

    /*public void setUserId(Integer userId){
        this.userId = userId;
    }
    public Integer getUserId(){
        return userId;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setAuth(Integer auth){
        this.auth = auth;
    }
    public Integer getAuth(){
        return auth;
    }*/

}
