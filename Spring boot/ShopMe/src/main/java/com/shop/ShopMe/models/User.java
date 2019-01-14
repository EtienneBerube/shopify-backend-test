package com.shop.ShopMe.models;

import javax.persistence.*;

@Entity()
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    @OneToOne(fetch = FetchType.EAGER)
    private ShoppingCart shopping_carts_id;
}
