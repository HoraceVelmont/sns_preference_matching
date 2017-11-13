package com.cafe24.sns.repository;

import com.cafe24.sns.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Person findById(Long id);
	List<Person> findByName(String name);
	List<Person> findAllByOrderByIdAsc();
}
