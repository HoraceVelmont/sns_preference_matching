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

	@Before
	public void setup(){

	}
	@Test
	public void testPersonInterestServiceCRUD(){
		Person p = new Person("김대훈", 27, "1.jpg");
		Interest i = new Interest();
		i.setName("라라랜드");

		PersonInterest personInterest = new PersonInterest();
		personInterest.setPerson(p);
		personInterest.setInterest(i);
		p.addPersonInterest(personInterest);
		service.add(personInterest);
	}
}
