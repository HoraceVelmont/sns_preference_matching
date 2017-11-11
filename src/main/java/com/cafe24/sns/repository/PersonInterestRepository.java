package com.cafe24.sns.repository;

import com.cafe24.sns.model.PersonInterest;
import com.cafe24.sns.model.PersonInterestId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonInterestRepository  extends CrudRepository<PersonInterest, PersonInterestId> {
	PersonInterest findById(Long id);
	List<PersonInterest> findByPerson(Long personId);
	List<PersonInterest> findByInterest(Long interestId);
}