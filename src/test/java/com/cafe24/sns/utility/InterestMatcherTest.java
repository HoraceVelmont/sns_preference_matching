package com.cafe24.sns.utility;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import com.cafe24.sns.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterestMatcherTest {
	@Autowired
	PersonService personService;

	@Test
	public void matchTest(){
		Person person1 = personService.get(2L);
		Person person2 = personService.get(3L);
		System.out.println(person2.getFriends().size());
		List<List<Match>> friendshipMatchList = InterestMatcher
				.getMatchListByCategory(person1, person2, Interest.Category.RESTAURANT);
		System.out.println(friendshipMatchList.get(0).size());
	}
}
