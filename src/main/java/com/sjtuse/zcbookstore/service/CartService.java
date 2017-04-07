package com.sjtuse.zcbookstore.service;

import com.sjtuse.zcbookstore.entity.Book;

import java.util.Map;

/**
 * Created by zcoaolas on 3/18/2017.
 */
public interface CartService {
    /**
     * Add an amount of books to cart
     * @param book the book entity
     * @param amount the number
     */
    void addToCart(Book book, Integer amount);

    /**
     * Get the cart of a user
     * @return the whole cart
     */
    Map<Book, Integer> getCart();

    /**
     * Clear the shopping cart of a user
     */
    void clearCart();
}
