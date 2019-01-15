package com.shop.ShopMe;

import com.shop.ShopMe.models.Product;
import com.shop.ShopMe.models.ShoppingCart;
import com.shop.ShopMe.models.User;
import com.shop.ShopMe.repositories.ProductRepository;
import com.shop.ShopMe.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
@EnableJpaRepositories
public class ShopMeApplication {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopMeApplication.class, args);
	}

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            productRepository.save(new Product("Computer",50.1F, 3));
            productRepository.save(new Product("Book",3.4F, 6));
            productRepository.save(new Product("Sneakers",199.0F, 7));
            productRepository.save(new Product("Cap",25.4F, 8));
            productRepository.save(new Product("Dragon",100000.0F, 1));

            userRepository.save(new User("Jessy J", new ShoppingCart()));
            userRepository.save(new User("Greg G", new ShoppingCart()));
        };
    }
}

