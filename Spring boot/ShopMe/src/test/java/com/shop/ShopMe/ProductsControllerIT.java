package com.shop.ShopMe;

import com.shop.ShopMe.controllers.ProductsController;
import com.shop.ShopMe.models.Product;
import org.hibernate.hql.internal.CollectionSubqueryFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsControllerIT {

    @Autowired
    ProductsController productsController;


    @Test
    public void load_all_products(){
        List<Product> retreived = productsController.getAllProducts(false);

        Product[] expectedArr = {new Product("Computer",50.1F, 3),
                new Product("Book",3.4F, 6),
                new Product("Sneakers",199.0F, 7),
                new Product("Cap",25.4F, 8),
                new Product("Dragon",100000.0F, 1),
                new Product("Holy Grail",1000000000.0F, 0)};

        List<Product> expected = new ArrayList<>(Arrays.asList(expectedArr));

        AssertTrue();

    }

    @Test
    public void load_all_available_products(){
        productsController.getAllProducts(true);
    }

    @Test
    public void load_product_with_id(){
        productsController.getProductById(1);
    }

    @Test
    public void load_product_with_id_doesnt_exist(){
        productsController.getProductById(99);
    }

    private boolean isListEqual(List<Product> list1, List<Product> list2){
        
    }
}
