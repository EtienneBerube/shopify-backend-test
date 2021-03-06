package com.shop.ShopMe.services.impls;

import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.models.ShoppingCart;
import com.shop.ShopMe.models.ShoppingCartElement;
import com.shop.ShopMe.models.User;
import com.shop.ShopMe.repositories.ProductRepository;
import com.shop.ShopMe.repositories.UserRepository;
import com.shop.ShopMe.services.UserService;
import com.shop.ShopMe.utils.exceptions.BadParametersException;
import com.shop.ShopMe.utils.exceptions.EmptyCartException;
import com.shop.ShopMe.utils.exceptions.NotEnoughInInventoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void addToCart(long userId, long productId, long quantity) {
        if(quantity < 0) return;

        User currentUser = userRepository.findById(userId).get();
        Product productToAdd = productRepository.findById(productId).get();

        if(currentUser == null || productToAdd == null) throw  new BadParametersException();

        if(productToAdd.getInventory_count() < quantity) throw new NotEnoughInInventoryException(productToAdd.getTitle(),quantity,productToAdd.getInventory_count());
        currentUser.getShoppingCart().addItem(productToAdd, quantity);

        this.userRepository.save(currentUser);
    }

    @Override
    public void removeFromCart(long userId, long productId, long quantity) {
        User currentUser = userRepository.findById(userId).get();

        if(currentUser == null ) throw  new BadParametersException();

        currentUser.getShoppingCart().removeItem(productId, quantity);

        this.userRepository.save(currentUser);
    }

    @Override
    public void removeAllFromCart(long userId, long productId) {
        User currentUser = userRepository.findById(userId).get();

        if(currentUser == null) throw  new BadParametersException();

        currentUser.getShoppingCart().clearCart();

        this.userRepository.save(currentUser);
    }

    @Override
    public String checkout(long userId) {
        User currentUser = userRepository.findById(userId).get();

        StringBuilder toReturn = new StringBuilder("");

        StringBuilder successful = new StringBuilder("Success (Qt): ");
        StringBuilder unsuccessful = new StringBuilder(" Unsuccessful (Qt):");

        if(currentUser == null) throw  new BadParametersException();

        if(currentUser.getShoppingCart().getElements().size() == 0) throw new EmptyCartException();

        //Used to bypass Concurrent modification error in forEach()
        List<ShoppingCartElement> toRemove = new ArrayList<>();

        currentUser.getShoppingCart().getElements().forEach((shoppingCartElement -> {
            if(shoppingCartElement.getQuantity() <= shoppingCartElement.getProduct().getInventory_count()){

                Product product = shoppingCartElement.getProduct();
                product.setInventory_count(product.getInventory_count() - shoppingCartElement.getQuantity());
                productRepository.save(product);

                toRemove.add(shoppingCartElement);
                successful.append(shoppingCartElement.getProduct().getTitle() + "("+shoppingCartElement.getQuantity()+"),");

            }else{
                unsuccessful.append(shoppingCartElement.getProduct().getTitle() + "("+shoppingCartElement.getQuantity()+"),");
            }
        }));


        toRemove.forEach(shoppingCartElement -> {
            currentUser.getShoppingCart().removeItem(shoppingCartElement);
        });

        //Create Return statement

        toReturn.append(successful).append(unsuccessful);

        userRepository.save(currentUser);

        return toReturn.toString();
    }

    @Override
    public ShoppingCart getCart(long userId) {
        User currentUser = userRepository.findById(userId).get();

        if(currentUser == null) throw  new BadParametersException();

        return currentUser.getShoppingCart();
    }

    @Override
    public void createUser(String name) {
        userRepository.save(new User(name, new ShoppingCart()));
    }
}
