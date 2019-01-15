package com.shop.ShopMe.utils.exceptions;

public class NotEnoughInInventoryException extends RuntimeException{
    public NotEnoughInInventoryException(String productTitle, long wantedQuantity, long actualQuantity) {
        super("Not enough " + productTitle +" in inventory. Wanted: " + wantedQuantity + ". In stock: " + actualQuantity);
    }
}
