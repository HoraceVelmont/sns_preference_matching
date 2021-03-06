package com.cafe24.sns.repository;

import com.cafe24.sns.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findByName(String name);

	List<Person> findAllByOrderByIdAsc();
}
