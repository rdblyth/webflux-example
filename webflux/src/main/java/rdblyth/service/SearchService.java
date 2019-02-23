package rdblyth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rdblyth.domain.Search;
import rdblyth.repository.SearchRepository;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class SearchService {

    @Autowired
    private SearchRepository repository;

    public Mono<Search> createSearch(Search search) {
        return Mono.fromCallable( () -> repository.save(search))
                .delayElement(Duration.ofMillis(200));
    }

    public Mono<Search> getSearch(Long id) {
        return Mono.fromCallable(() -> repository.findById(id).get());
    }
}
