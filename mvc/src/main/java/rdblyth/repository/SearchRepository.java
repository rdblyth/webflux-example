package rdblyth.repository;

import org.springframework.data.repository.CrudRepository;
import rdblyth.domain.Search;

public interface SearchRepository extends CrudRepository<Search, Long> {
}
