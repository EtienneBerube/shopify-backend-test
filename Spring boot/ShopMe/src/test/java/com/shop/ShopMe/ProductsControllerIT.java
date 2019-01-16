package com.shop.ShopMe;

import com.shop.ShopMe.controllers.ProductsController;
import com.shop.ShopMe.models.Product;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsControllerIT {

    @Autowired
    ProductsController productsController;


    @Test
    public void load_all_products(){
        List<Product> retreived = productsController.getAllProducts(false);

        Product[] expectedArr = {new Product(1, "Computer",50.1F, 3),
                new Product(2,"Book",3.4F, 6),
                new Product(3,"Sneakers",199.0F, 7),
                new Product(4,"Cap",25.4F, 8),
                new Product(5,"Dragon",100000.0F, 1),
                new Product(6,"Holy Grail",1000000000.0F, 0)};

        List<Product> expected = new ArrayList<>(Arrays.asList(expectedArr));

        assertTrue(CollectionUtils.isEqualCollection(retreived,expected));

    }

    @Test
    public void load_all_available_products(){
        List<Product> retreived = productsController.getAllProducts(true);

        Product[] expectedArr = {new Product(1, "Computer",50.1F, 3),
                new Product(2,"Book",3.4F, 6),
                new Product(3,"Sneakers",199.0F, 7),
                new Product(4,"Cap",25.4F, 8),
                new Product(5,"Dragon",100000.0F, 1)};

        List<Product> expected = new ArrayList<>(Arrays.asList(expectedArr));

        assertTrue(CollectionUtils.isEqualCollection(retreived,expected));
    }

    @Test
    public void load_product_with_id(){
        Product retreived = productsController.getProductById(2);

        Product expected = new Product(2,"Book",3.4F, 6);

        assertEquals(retreived, expected);
    }

    @Test
    public void load_product_with_id_doesnt_exist(){
        Product product =  productsController.getProductById(99);
        assertNull(product);
    }

    @Test
    public void create_product_can_retreived(){
        Product expected = new Product(13,"Test",1.1F,99);
        productsController.createProduct(expected);
        Product retreived =  productsController.getProductById(13);
        assertEquals(expected, retreived);
    }
}
