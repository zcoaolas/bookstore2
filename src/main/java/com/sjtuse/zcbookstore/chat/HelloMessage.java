package com.sjtuse.zcbookstore.chat;

/**
 * Created by zcoaolas on 2017/4/15.
 */
public class HelloMessage {

    private String name;
    private String msg;

    public HelloMessage() {
    }

    public HelloMessage(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
