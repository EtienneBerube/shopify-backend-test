package com.shop.ShopMe.models;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    public User() {
    }

    public User(String name, ShoppingCart shopping_cart) {
        this.name = name;
        this.shoppingCart = shopping_cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shopping_cart) {
        this.shoppingCart = shopping_cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(shoppingCart, user.shoppingCart);
    }
}
