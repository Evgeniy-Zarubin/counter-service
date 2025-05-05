package org.skypro.counter.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.counter.model.search.Searchable;
import java.util.Objects;
import java.util.UUID;

public class Product implements Searchable {
    protected final String nameProduct;
    protected final UUID id;


    public Product(UUID id, String nameProduct) {
        if (nameProduct == null || nameProduct.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не должно быть пустым или null");
        }
        this.nameProduct = nameProduct;
        this.id = id;
    }

    @Override
    public String getName() {
        return nameProduct;
    }

    public double getPrice() {
        return 0;
    }

    public boolean isSpecial() {
        return false;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return "Продукт: " + nameProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }

    @Override
    public String toString() {
        return "Product{name='" + nameProduct + '}';
    }

    @Override
    public UUID getId() {
        return id;
    }
}
