package com.shop.ShopMe.models;

import com.shop.ShopMe.utils.generators.UseIdOrGenerate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="IdOrGenerated")
    @GenericGenerator(name="IdOrGenerated",
            strategy="com.shop.ShopMe.utils.generators.UseIdOrGenerate"
    )
    private Long id;

    @Column
    private String title;

    @Column
    private float price;

    @Column
    private long inventory_count;

    public Product() {
    }

    public Product(String title, float price, int inventory_count) {
        this.title = title;
        this.price = price;
        this.inventory_count = inventory_count;
    }

    public Product(long id, String title, float price, int inventory_count) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.inventory_count = inventory_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getInventory_count() {
        return inventory_count;
    }

    public void setInventory_count(long inventory_count) {
        this.inventory_count = inventory_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Float.compare(product.price, price) == 0 &&
                inventory_count == product.inventory_count &&
                Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, inventory_count);
    }
}
