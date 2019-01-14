package com.shop.ShopMe.controllers;

import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
