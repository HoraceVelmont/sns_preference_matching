package com.cafe24.sns.repository;

import com.cafe24.sns.model.PersonInterest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonInterestRepository extends CrudRepository<PersonInterest, Long> {
	PersonInterest findById(Long id);

	List<PersonInterest> findByPerson(Long personId);

	List<PersonInterest> findByInterest(Long interestId);
}