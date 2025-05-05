package org.skypro.counter.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final double FIXED_PRICE = 10900.00;

    public FixPriceProduct(UUID id, String nameProduct) {
        super(id, nameProduct);
    }

    @Override
    public double getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return nameProduct + ": Фиксированная цена " + FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
