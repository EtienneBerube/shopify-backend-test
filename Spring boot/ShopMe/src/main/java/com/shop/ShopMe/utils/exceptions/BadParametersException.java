package com.shop.ShopMe.utils.exceptions;

public class BadParametersException extends RuntimeException {
    public BadParametersException() {
        super("Bad parameters used for API call");
    }
}
