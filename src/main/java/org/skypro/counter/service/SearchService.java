package org.skypro.counter.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.naming.directory.SearchResult;
import java.util.List;


@Service
public class SearchService {

    private final StorageService storageService;

    @Autowired
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