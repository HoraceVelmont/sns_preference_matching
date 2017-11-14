package com.cafe24.sns.controller;

import com.cafe24.sns.model.Friendship;
import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import com.cafe24.sns.service.PersonService;
import com.cafe24.sns.utility.InterestMatcher;
import com.cafe24.sns.utility.Match;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchingController {
	@Autowired
	private PersonService personService;

	@GetMapping("/restaurants")
	public @ResponseBody
	String matchRestaurant(@RequestParam("person1") Long person1id, @RequestParam("person2") Long person2id)
			throws JsonProcessingException {
		Person person1 = personService.get(person1id);
		Person person2 = personService.get(person2id);
		List<List<Match>> friendshipMatchList = InterestMatcher
				.getMatchListByCategory(person1, person2, Interest.Category.RESTAURANT);

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(friendshipMatchList);
	}
}
