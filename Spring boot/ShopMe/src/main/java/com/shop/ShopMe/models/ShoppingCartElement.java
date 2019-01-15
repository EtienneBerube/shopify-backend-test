package com.shop.ShopMe.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping_cart_elements")
public class ShoppingCartElement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    private long quantity;

    public ShoppingCartElement() {
    }

    public ShoppingCartElement(Product product, long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public float getValue(){
        return product.getPrice()*quantity;
    }
}
