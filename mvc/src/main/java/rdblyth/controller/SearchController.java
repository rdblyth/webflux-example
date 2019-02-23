package rdblyth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rdblyth.domain.Search;
import rdblyth.service.SearchService;

@RestController
@RequestMapping("/searches")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/{id}")
    public Search getSearch(@PathVariable("id") Long id) {
        return searchService.getSearch(id);
    }

    @PostMapping
    public Search createSearch(@RequestBody Search search) {
        return searchService.createSearch(search);
    }
}
