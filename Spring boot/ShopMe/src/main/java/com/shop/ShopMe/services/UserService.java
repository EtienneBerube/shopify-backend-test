package com.shop.ShopMe.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.shop.ShopMe.models.ShoppingCart;
import com.shop.ShopMe.repositories.ProductRepository;
import com.shop.ShopMe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {
    void addToCart(long userId, long productId, long quantity);
    void removeFromCart(long userId, long productId,long quantity);
    void removeAllFromCart(long userId, long productId);
    String checkout(long userId);
    ShoppingCart getCart(long userId);
}
