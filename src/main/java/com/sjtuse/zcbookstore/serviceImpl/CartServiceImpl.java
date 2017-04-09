package com.sjtuse.zcbookstore.serviceImpl;

import com.sjtuse.zcbookstore.entity.Book;
import com.sjtuse.zcbookstore.entity.Cart;
import com.sjtuse.zcbookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by zcoaolas on 3/18/2017.
 */

@Scope(scopeName="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
@Service
public class CartServiceImpl implements CartService, Serializable {

    private Cart cart;

    public CartServiceImpl(){
        cart = new Cart();
    }

    public void addToCart(Book book, Integer amount){
        cart.addToCart(book, amount);
    }

    public Map<Book, Integer> getCart(){
        return cart.getCart();
    }

    public void clearCart(){
        cart.clearCart();
    }

    public BigDecimal getTotalPrice(){
        return cart.getTotalPrice();
    }

}
