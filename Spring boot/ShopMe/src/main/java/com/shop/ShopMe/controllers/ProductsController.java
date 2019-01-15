package com.shop.ShopMe.controllers;

import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam Boolean showOnlyAvailable){
        if(showOnlyAvailable){
            return productService.getAllProducts();
        }else{
            return productService.getAllAvailableProducts();
        }

    }

    @GetMapping("/products/{id}")
    public Product getAllProducts(@PathVariable(value="id") long id){
        return productService.getProductById(id);
    }
}
