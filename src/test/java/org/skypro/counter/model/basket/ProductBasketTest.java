package org.skypro.counter.model.basket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.resolver.MockParameterResolver;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockParameterResolver.class)
class ProductBasketTest {
    private final ProductBasket productBasket = new ProductBasket();

    @Test
    @DisplayName("Корректно добавляет продукт в корзину")
    void addProductNew() {
        UUID productUuid = java.util.UUID.randomUUID();

        //test
        productBasket.addProduct(productUuid);

        //check
        Map<UUID, Integer> actualMap = productBasket.getProductBasket();
        assertEquals(actualMap.size(), 1);
        Integer actual = actualMap.get(productUuid);
        assertEquals(actual, 1);

    }

    @Test
    @DisplayName("Корректно добавляет продукт в корзину повторно")
    void addProductCurrent() {
        UUID productUuid = java.util.UUID.randomUUID();
        productBasket.addProduct(productUuid);

        //test
        productBasket.addProduct(productUuid);

        //check
        Map<UUID, Integer> actualMap = productBasket.getProductBasket();
        assertEquals(actualMap.size(), 1);
        Integer actual = actualMap.get(productUuid);
        assertEquals(actual, 2);

    }

    @Test
    @DisplayName("Корректно возвращает все товары из корзины")
    void getProductBasket() {
        UUID productUuid = java.util.UUID.randomUUID();
        productBasket.addProduct(productUuid);


        //test
        Map<UUID, Integer> actualMap = productBasket.getProductBasket();


        //check
        assertThat(actualMap).isNotEmpty().hasSize(1);
        assertThat(actualMap.get(productUuid)).isNotNull().isEqualTo(1);
    }
}