package com.shop.ShopMe.services.impls;

import com.shop.ShopMe.repositories.ProductRepository;
import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllAvailableProducts() {
        return productRepository.findAllAvailableProducts();
    }
}
