package com.cafe24.sns.repository;

import com.cafe24.sns.model.Interest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InterestRepository extends CrudRepository<Interest, Long> {
	List<Interest> findByCategory(Interest.Category category);

	Interest findByName(String name);
}
