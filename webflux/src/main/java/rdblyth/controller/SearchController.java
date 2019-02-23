package rdblyth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rdblyth.domain.Search;
import rdblyth.service.SearchService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/searches")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/{id}")
    public Mono<Search> getSearch(@PathVariable("id") Long id) {
        return searchService.getSearch(id);
    }

    @PostMapping
    public Mono<Search> createSearch(@RequestBody Search search) {
        return searchService.createSearch(search);
    }
}
