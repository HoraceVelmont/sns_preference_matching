package com.cafe24.sns.controller;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import com.cafe24.sns.model.PersonInterest;
import com.cafe24.sns.repository.InterestRepository;
import com.cafe24.sns.repository.PersonInterestRepository;
import com.cafe24.sns.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	String home(){
		return "index";
	}
}
