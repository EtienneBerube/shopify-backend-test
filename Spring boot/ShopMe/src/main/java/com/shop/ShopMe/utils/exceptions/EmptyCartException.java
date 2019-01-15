package com.shop.ShopMe.utils.exceptions;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException() {
        super("Cannot Checkout, Cart is empty");
    }
}
