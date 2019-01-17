package com.shop.ShopMe.controllers;

import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(required = false) Boolean showOnlyAvailable){
        if(showOnlyAvailable != null && showOnlyAvailable){
            return productService.getAllAvailableProducts();
        }else{
            return productService.getAllProducts();
        }
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable(value="id") long id){
        return productService.getProductById(id);
    }

    @PostMapping("/products/new")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }
}
