package com.shop.ShopMe.services.impls;

import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.models.User;
import com.shop.ShopMe.repositories.ProductRepository;
import com.shop.ShopMe.repositories.UserRepository;
import com.shop.ShopMe.services.UserService;
import com.shop.ShopMe.utils.exceptions.BadParametersException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void addToCart(long userId, long productId, long quantity) {
        User currentUser = userRepository.findById(userId).get();
        Product productToAdd = productRepository.findById(userId).get();

        if(currentUser != null || productToAdd != null) throw  new BadParametersException();

        currentUser.getShopping_cart().

    }

    @Override
    public void removeFromCart(long userId, long productId, long quantity) {

    }

    @Override
    public void removeAllFromCart(long userId, long productId) {

    }

    @Override
    public void checkout(long userId) {

    }
}
