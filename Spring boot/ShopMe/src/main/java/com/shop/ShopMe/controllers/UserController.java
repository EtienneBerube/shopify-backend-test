package com.shop.ShopMe.controllers;


import com.shop.ShopMe.models.ShoppingCart;
import com.shop.ShopMe.services.ProductService;
import com.shop.ShopMe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @PutMapping("/{userId}/add-to-cart")
    public void addItemToCart(@PathVariable long userId, @RequestParam long productId, @RequestParam long quantity){
         userService.addToCart(userId,productId, quantity);
    }

    @GetMapping("/{userId}/cart")
    public ShoppingCart getCart(@PathVariable long userId){
        return userService.getCart(userId);
    }

    @PutMapping("/{userId}/remove-from-cart")
    public void removeFromCart(@PathVariable long userId, @RequestParam long productId, @RequestParam(required = false) Boolean removeAll, @RequestParam(required = false) Long quantity){
        if(removeAll){
            userService.removeAllFromCart(userId, productId);
        }else {
            userService.removeFromCart(userId, productId, quantity);
        }
    }

    @PutMapping("/{userId}/checkout")
    public String checkout(@PathVariable long userId){
        return userService.checkout(userId);
    }

    @PostMapping("/user/new")
    public void createUser(@RequestParam String name){
        userService.createUser(name);
    }
}
