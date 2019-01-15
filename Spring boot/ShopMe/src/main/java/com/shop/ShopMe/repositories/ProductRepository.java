package com.shop.ShopMe.repositories;

import com.shop.ShopMe.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    @Query("select p from Product p where p.inventory_count > 0")
    List<Product> findAllAvailableProducts();
}
