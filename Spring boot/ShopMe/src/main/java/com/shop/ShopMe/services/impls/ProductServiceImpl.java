package com.shop.ShopMe.services.impls;

import com.shop.ShopMe.JpaRepositories.ProductRepository;
import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
}
