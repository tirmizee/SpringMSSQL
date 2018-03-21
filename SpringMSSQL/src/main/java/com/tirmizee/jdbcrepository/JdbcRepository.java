package com.tirmizee.jdbcrepository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author pratya yeekhaday
 *
 * @see JDBC specific extension of {@link org.springframework.data.repository.Repository}.
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
public interface JdbcRepository<T extends Persistable<ID>, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
	
	<S extends T> List<S> save(Iterable<S> entities);
	
	List<T> findAll();
	
	List<T> findAll(Iterable<ID> ids);
	
	List<T> findAll(Sort sort);
	
}
