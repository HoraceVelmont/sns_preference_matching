package com.cafe24.sns.repository;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InterestRepository extends CrudRepository<Interest, Long> {
	Interest findById(Long id);
	List<Interest> findByCategory(Interest.Category category);
}
