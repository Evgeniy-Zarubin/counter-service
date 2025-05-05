package org.skypro.counter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.skypro.counter.Exception.NoSuchProductException;
import org.skypro.counter.model.product.Product;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

class StorageServiceTest {

    @InjectMocks
    private StorageService storageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllProducts() {
        given(storageService.getAllProducts()).willReturn(Collection.emptySet());
        assertTrue(storageService.getAllProducts().isEmpty());
    }

    @Test
    void shouldThrowNoSuchProductExceptionForNonExistingProduct() {
        UUID nonExistentID = UUID.randomUUID(); // генерируем уникальный идентификатор отсутствующего товара
        assertThrows(NoSuchProductException.class, () -> {storageService.getProductById(nonExistentID);});
    }

    @Test
    void shouldFindExistingProduct() throws NoSuchProductException {
        Product existingProduct = new Product(UUID.randomUUID(), "test_product");
        given(storageService.getProductById(existingProduct.getId())).willReturn(Optional.of(existingProduct));
        assertTrue(storageService.getProductById(existingProduct.getId()).isPresent()); // проверка наличия товара
    }

    @Test
    void shouldGetAllArticles() {
        given(storageService.getAllArticles()).willReturn(Collection.emptySet());
        assertTrue(storageService.getAllArticles().isEmpty());
    }

    @Test
    void shouldProvideSearchableCollection() {
        given(storageService.getAllSearchables()).willReturn(Collection.emptySet());
        assertTrue(storageService.getAllSearchables().isEmpty());
    }
}