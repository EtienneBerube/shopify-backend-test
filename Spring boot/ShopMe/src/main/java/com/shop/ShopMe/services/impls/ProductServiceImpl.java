package com.shop.ShopMe.services.impls;

import com.shop.ShopMe.repositories.ProductRepository;
import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        Product toReturn;
        try{
            toReturn = productRepository.findById(id).get();
        }catch(NoSuchElementException ex){
            toReturn = null;
        }
        return toReturn;
    }

    @Override
    public void createProduct(Product p) {
        productRepository.save(p);
    }

    @Override
    public List<Product> getAllAvailableProducts() {
        return productRepository.findAllAvailableProducts();
    }
}
