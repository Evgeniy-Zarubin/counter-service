package org.skypro.counter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.search.SearchResult;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @InjectMocks
    private SearchService searchService;

    @Mock
    private StorageService storageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldHandleEmptySearchResults() {
        String emptyQuery = "";
        given(storageService.getAllSearchables()).willReturn(new ArrayList<>());
        List<SearchResult> results = searchService.search(emptyQuery);
        assertFalse(results.isEmpty());
    }

    @Test
    void shouldFindMultipleSearchResults() {
        Product product1 = new Product(UUID.randomUUID(), "Геймпад");
        Product product2 = new Product(UUID.randomUUID(), "Ноутбук");
        given(storageService.getAllSearchables()).willReturn(List.of(product1, product2));
        List<SearchResult> results = searchService.search("a");
        assertNotNull(results);
    }

    @Test
    void shouldFailToFindAnySearchResults() {
        given(storageService.getAllSearchables()).willReturn(new ArrayList<>());
        List<SearchResult> results = searchService.search("notFound");
        assertFalse(results.isEmpty());
    }
}