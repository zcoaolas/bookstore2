package com.sjtuse.zcbookstore.helper.jaas;

import java.security.Principal;

/**
 * Created by zcoaolas on 3/16/2017.
 */
public class SimplePrincipal implements Principal {
    private String descr;
    private String value;

    public SimplePrincipal(String descr, String value){
        this.descr = descr;
        this.value = value;
    }

    public String getName(){
        return descr + "=" + value;
    }
    public String getDescr(){
        return descr;
    }
    public String getValue(){
        return value;
    }

    /*@Override
    public int hashCode(){
        return Objects.hashCode(getName());
    }*/
}
