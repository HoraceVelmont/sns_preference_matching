package com.cafe24.sns.controller;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import com.cafe24.sns.model.PersonInterest;
import com.cafe24.sns.repository.InterestRepository;
import com.cafe24.sns.repository.PersonInterestRepository;
import com.cafe24.sns.repository.PersonRepository;
import com.cafe24.sns.service.PersonInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@Autowired
	PersonInterestService personInterestService;

	@GetMapping(value="")
	String home(){
		return "index";
	}


	@Bean
	public CommandLineRunner runner() {
		return (a) -> {
			Person p = new Person("김대훈", 27, "1.jpg");
			Interest i = new Interest();
			i.setName("라라랜드");

			Person p2 = new Person("강백호", 17, "2.jpg");
			Interest i2 = new Interest();
			i2.setName("신전떡볶이");

			PersonInterest personInterest = new PersonInterest();
			personInterest.setPerson(p);
			personInterest.setInterest(i);

			PersonInterest personInterest2 = new PersonInterest();
			personInterest2.setPerson(p2);
			personInterest2.setInterest(i2);

			p.addPersonInterest(personInterest);
			p2.addPersonInterest(personInterest2);
			personInterestService.add(personInterest);
			personInterestService.add(personInterest2);
		};
	}
}
