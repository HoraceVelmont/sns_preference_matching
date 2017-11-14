package com.cafe24.sns.service;

import com.cafe24.sns.model.Person;
import com.cafe24.sns.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class PersonService {
	@Autowired
	PersonRepository repository;

	public Person get(Long id){ return repository.findOne(id); }

	public Long getCount() {return repository.count();}

	public Person add(Person person){
		return repository.save(person);
	}

	public List<Person> getAll(){
		return repository.findAllByOrderByIdAsc();
	}
}
