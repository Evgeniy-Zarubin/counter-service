package org.skypro.counter.service;
import org.springframework.stereotype.Service;
import org.skypro.counter.model.search.SearchResult;
import java.util.List;


@Service
public class SearchService {

    private final StorageService storageService;


    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String query) {
        return storageService.getAllSearchables()
                .stream()
                .filter(searchable -> searchable.getName().contains(query))
                .map(SearchResult::fromSearchable)
                .toList();
    }
}