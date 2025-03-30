package org.skypro.counter.model.search;
import org.skypro.counter.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.naming.directory.SearchResult;
import java.util.List;
import java.util.stream.Collectors;

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
                .collect(Collectors.toList());
    }
}