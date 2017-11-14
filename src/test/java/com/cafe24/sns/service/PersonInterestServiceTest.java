package com.cafe24.sns.service;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import com.cafe24.sns.model.PersonInterest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonInterestServiceTest {
	@Autowired
	private PersonInterestService service;
	@Autowired
	private PersonService personService;

	@Before
	public void setup(){

	}
	@Test
	public void testPersonInterestServiceCRUD(){
		Person person = personService.get(2L);
		System.out.println(person.getPersonInterestList().size());
	}
}
