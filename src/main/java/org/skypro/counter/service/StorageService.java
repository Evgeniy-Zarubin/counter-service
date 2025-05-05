package org.skypro.counter.service;
import org.skypro.counter.Exception.NoSuchProductException;
import org.skypro.counter.model.article.Article;
import org.skypro.counter.model.product.Product;
import org.skypro.counter.model.search.Searchable;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        this.initTestData();
    }

    private void initTestData() {

        Product product1 = new Product(UUID.randomUUID(), "Геймпад");
        Product product2 = new Product(UUID.randomUUID(), "Ноутбук");
        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);

        Article article1 = new Article( UUID.randomUUID(),"Статья о Геймпаде", "Геймпад со стиками");
        Article article2 = new Article( UUID.randomUUID(),"Статья о Ноутбуке", "Ноутбук от Acer");
        articles.put(article1.getId(), article1);
        articles.put(article2.getId(), article2);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Optional<Product> getProductById(UUID id){
        if (!products.containsKey(id)) {
            throw new NoSuchProductException(id);
        }
        return Optional.ofNullable(products.get(id));
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Searchable> getAllSearchables() {
        return Stream.concat(
                        products.values().stream(),
                        articles.values().stream())
                .collect(Collectors.toList());
    }
}