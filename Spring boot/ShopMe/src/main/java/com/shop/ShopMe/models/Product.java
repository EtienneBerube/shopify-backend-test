package com.shop.ShopMe.models;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    @Column
    private float price;

    @Column
    private int inventory_count;
}
