package org.skypro.counter.model.basket;

import org.skypro.counter.model.product.Product;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserBasket {
    private final List<BasketItem> items;
    private final double total;

    public UserBasket(List<BasketItem> items) {
        this.items = Objects.requireNonNull(items, "Items list cannot be null");
        this.total = calculateTotal(items);
    }

    public double getTotalCost() {
        return product.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBasket that = (UserBasket) o;
        return Objects.equals(items, that.items) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, total);
    }

    @Override
    public String toString() {
        return "UserBasket{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
