package com.cafe24.sns.utility;

import com.cafe24.sns.service.InterestService;
import com.cafe24.sns.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomPersonMakerTest {
	@Autowired
	private RandomPersonMaker randomPersonMaker;
	@Autowired
	private PersonService personService;
	@Autowired
	private InterestService interestService;

	private static final int PERSON_COUNT = 200;
	private static final int INTEREST_COUNT = 30;

	@Test
	public void testAutoWiring() {
		InterestService interestService = randomPersonMaker.getInterestService();
		assertNotNull(interestService);
	}

	@Test
	public void testRandomMaker() {
		randomPersonMaker.makeModel(PERSON_COUNT, INTEREST_COUNT);
		assertThat(personService.getCount(), is(PERSON_COUNT));
		assertThat(interestService.getCount(), is(INTEREST_COUNT));
	}
}
