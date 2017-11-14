package com.cafe24.sns.service;

import com.cafe24.sns.model.PersonInterest;
import com.cafe24.sns.repository.PersonInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class PersonInterestService {
	@Autowired
	private PersonInterestRepository repository;

	public void add(PersonInterest personInterest){	repository.save(personInterest);}

	public void delete(PersonInterest personInterest){
		repository.delete(personInterest);
	}
}
