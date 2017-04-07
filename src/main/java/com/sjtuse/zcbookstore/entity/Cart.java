package com.sjtuse.zcbookstore.entity;

import com.sjtuse.zcbookstore.entity.Book;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ejb.Stateful;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcoaolas on 3/18/2017.
 */
public class Cart {
    private HashMap<Book, Integer> cart;

    public Cart(){
        cart = new HashMap<Book, Integer>();
    }

    public void addToCart(Book book, Integer amount){
        for (HashMap.Entry<Book, Integer> e : cart.entrySet()) {
            if (e.getKey().equals(book)) {
                cart.put(e.getKey(), e.getValue() + amount);
                return;
            }
        }
        cart.put(book, amount);
    }

    public Map<Book, Integer> getCart(){
        return cart;
    }

    public void clearCart(){
        cart.clear();
    }
}
