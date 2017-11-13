package com.cafe24.sns.service;

import com.cafe24.sns.model.Person;
import com.cafe24.sns.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
	@Autowired
	PersonRepository repository;

	public Person add(Person person){
		return repository.save(person);
	}

	public List<Person> getAll(){
		return repository.findAllByOrderByIdAsc();
	}
}
