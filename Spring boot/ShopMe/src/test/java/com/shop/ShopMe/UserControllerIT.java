package com.shop.ShopMe;

import com.shop.ShopMe.controllers.ProductsController;
import com.shop.ShopMe.controllers.UserController;
import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.models.ShoppingCart;
import com.shop.ShopMe.models.User;
import com.shop.ShopMe.repositories.ProductRepository;
import com.shop.ShopMe.repositories.UserRepository;
import com.shop.ShopMe.utils.exceptions.NotEnoughInInventoryException;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerIT {

    @Autowired
    UserController userController;

    @Autowired
    ProductsController productsController;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void can_add_item(){
        userController.addItemToCart(1,1,1);
        Product expected = productsController.getProductById(1);
        ShoppingCart currentShoppingCart = userController.getCart(1);

        Assert.assertEquals(1, currentShoppingCart.getElements().size());
        Assert.assertEquals(currentShoppingCart.getElements().get(0).getProduct(),expected);
    }

    //TODO add assertThrown for Junit 4
    @Test(expected = NotEnoughInInventoryException.class)
    public void cannot_add_item_with_not_enough_inventory(){
        userController.addItemToCart(1,1,5);
    }

    @Test
    public void can_remove_quantity_item(){
        userController.addItemToCart(1,1,2);
        ShoppingCart currentShoppingCart = userController.getCart(1);
        Product expected = productsController.getProductById(1);
        userController.removeFromCart(1,1,false,1L);

        Assert.assertEquals(1, currentShoppingCart.getElements().size());
        Assert.assertEquals(expected.getPrice(), currentShoppingCart.getTotal_price(), 0.0);
    }

    @Test
    public void can_remove_item_completely(){
        userController.addItemToCart(1,1,2);
        userController.removeFromCart(1,1,true,null);
        ShoppingCart currentShoppingCart = userController.getCart(1);

        Assert.assertEquals(0, currentShoppingCart.getElements().size());
        Assert.assertEquals(0F, currentShoppingCart.getTotal_price(), 0.0);
    }

    @Test
    public void can_checkout(){
        userController.addItemToCart(1,1,1);
        Product product = productsController.getProductById(1);

        String status = userController.checkout(1);
        String expected = "Success (Qt): "+product.getTitle()+"(1), Unsuccessful (Qt):";

        ShoppingCart shoppingCart = userController.getCart(1);

        Assert.assertEquals(0, shoppingCart.getElements().size());
        Assert.assertEquals(0, shoppingCart.getTotal_price(),0);
        Assert.assertEquals(status, expected);
    }

    @Test
    public void cannot_checkout_items_with_not_enough_quantity(){
        userController.addItemToCart(1,1,3);
        Product product = productsController.getProductById(1);

        //Inventory count will be one less than requested
        product.setInventory_count(product.getInventory_count()-1);

        productRepository.saveAndFlush(product);

        String status = userController.checkout(1);
        String expected = "Success (Qt):  Unsuccessful (Qt):"+product.getTitle()+"(3),";

        ShoppingCart shoppingCart = userController.getCart(1);

        Assert.assertEquals(1, shoppingCart.getElements().size());

        //Delta caused by float -> double conversion
        Assert.assertEquals(product.getPrice()*3, shoppingCart.getTotal_price(),0.001);
        Assert.assertEquals(status, expected);
    }


}
