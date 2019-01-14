package com.shop.ShopMe.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name="shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private float total_price;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "products_shopping_carts",
            joinColumns = { @JoinColumn(name = "shopping_cart_id_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    List<Product> projects;

}
