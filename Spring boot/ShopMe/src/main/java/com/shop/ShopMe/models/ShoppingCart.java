package com.shop.ShopMe.models;

import com.shop.ShopMe.utils.exceptions.BadParametersException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name="shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private float total_price;

    @OneToMany(targetEntity = ShoppingCartElement.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<ShoppingCartElement> elements;

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

    public List<ShoppingCartElement> getElements() {
        return elements;
    }

    public void setElements(List<ShoppingCartElement> elements) {
        this.elements = elements;
    }

    public void addItem(Product product, long quantity){
        List<ShoppingCartElement> existingElement = this.elements.stream().filter((element)->element.getProduct().getId() == product.getId()).collect(Collectors.toList());

        if(existingElement.size() > 0){
            existingElement.get(0).setQuantity( existingElement.get(0).getQuantity() + quantity);
        }else {
            this.elements.add(new ShoppingCartElement(product, quantity));
        }
        total_price = calculateValue();
    }

    public void removeItem(long productId, long quantity){
        //Should always be one
        List<ShoppingCartElement> toRemove = this.elements.stream().filter((element)->element.getProduct().getId() == productId).collect(Collectors.toList());

        if(toRemove.size() == 1){
            ShoppingCartElement item = toRemove.get(0);

            if(item.getQuantity()-quantity > 0){
                //Decrease by the desired quantity
                item.setQuantity(item.getQuantity()-quantity);
            }else{
                //Remove item completety
                this.elements.remove(item);
            }
        }else{
            throw new BadParametersException();
        }

        total_price = calculateValue();
    }

    public void clearCart(){
        this.elements = new ArrayList<>();
        this.total_price = 0;
    }

    public void removeItem(ShoppingCartElement item){
        this.elements.remove(item);

        total_price = calculateValue();
    }

    private float calculateValue(){
        float value = 0;

        for(ShoppingCartElement item: elements){
            value += item.getProduct().getPrice()*item.getQuantity();
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return id == that.id &&
                Float.compare(that.total_price, total_price) == 0 &&
                Objects.equals(elements, that.elements);
    }
}
