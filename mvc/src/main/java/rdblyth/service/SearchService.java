package rdblyth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rdblyth.domain.Search;
import rdblyth.repository.SearchRepository;

@Service
public class SearchService {

    @Autowired
    private SearchRepository repository;

    public Search createSearch(Search search) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return repository.save(search);
    }

    public Search getSearch(Long id) {
        return repository.findById(id).get();
    }
}
