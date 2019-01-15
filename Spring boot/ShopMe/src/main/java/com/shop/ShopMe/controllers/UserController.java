package com.shop.ShopMe.controllers;


import com.shop.ShopMe.models.ShoppingCart;
import com.shop.ShopMe.services.ProductService;
import com.shop.ShopMe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @PutMapping("/add-to-cart")
    void addItemToCart(@RequestParam long userId, @RequestParam long productId, @RequestParam long quantity){
         userService.addToCart(userId,productId, quantity);
    }

    @GetMapping("/cart")
    ShoppingCart getCart(@RequestParam long userId){
        return userService.getCart(userId);
    }

    @PutMapping("/remove-from-cart")
    void removeFromCart(@RequestParam long userId, @RequestParam long productId, @RequestParam(required = false) Boolean removeAll, @RequestParam(required = false) Long quantity){
        if(removeAll){
            userService.removeAllFromCart(userId, productId);
        }else {
            userService.addToCart(userId, productId, quantity);
        }
    }

    @PutMapping("/checkout")
    String checkout(@RequestParam long userId){
        return userService.checkout(userId);
    }
}
