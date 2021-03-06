package com.shop.ShopMe.services;

import com.shop.ShopMe.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById( long id);
    void createProduct(Product p);
    List<Product> getAllAvailableProducts();
}
