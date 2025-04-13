package org.skypro.counter.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final double price;

    public SimpleProduct(UUID id, String nameProduct, double price) {
        super(id, nameProduct);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не должна быть меньше или равна нулю");
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;

    }

    @Override
    public String toString() {
        return nameProduct + ": " + getPrice();
    }

}
