package com.nttdata.jpah2test.repository;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.jpah2test.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByName(String name);

	
	void delete(Book entity);
		
	
	void deleteById(Long id);
	

	Optional<Book> findById(Long id);
	

}
