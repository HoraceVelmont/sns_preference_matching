package com.cafe24.sns.controller;

import com.cafe24.sns.service.PersonInterestService;
import com.cafe24.sns.utility.RandomPersonMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@Autowired
	private PersonInterestService personInterestService;
	@Autowired
	private RandomPersonMaker randomPersonMaker;

	@GetMapping(value = "")
	String home() {
		return "index";
	}
}
