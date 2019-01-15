package com.shop.ShopMe.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private float total_price;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "products_shopping_carts",
            joinColumns = { @JoinColumn(name = "shopping_cart_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    List<Product> products;

    public ShoppingCart() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public List<Product> getProjects() {
        return products;
    }

    public void setProjects(List<Product> projects) {
        this.products = projects;
    }

    public void addItem(Product product){
        this.products.add(product);
    }
}
