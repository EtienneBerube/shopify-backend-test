package com.shop.ShopMe.services;

import com.shop.ShopMe.models.ShoppingCart;


public interface UserService {
    void addToCart(long userId, long productId, long quantity);
    void removeFromCart(long userId, long productId,long quantity);
    void removeAllFromCart(long userId, long productId);
    String checkout(long userId);
    ShoppingCart getCart(long userId);
    void createUser(String name);
}
