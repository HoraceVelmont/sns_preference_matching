package com.cafe24.sns.controller;

import com.cafe24.sns.model.Person;
import com.cafe24.sns.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private PersonService personService;

	@GetMapping("")
	public String getPersonList() throws JsonProcessingException {
		List<Person> personList = personService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(personList);
	}
}
