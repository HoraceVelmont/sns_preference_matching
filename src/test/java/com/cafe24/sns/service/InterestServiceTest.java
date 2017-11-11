package com.cafe24.sns.service;

import com.cafe24.sns.model.Interest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterestServiceTest {
	@Autowired
	private InterestService interestService;
	private Interest interest;

	@Before
	public void setup(){
		interest = new Interest("신전떡볶이", Interest.Category.RESTAURANT);
	}

	@Test
	public void testInterestCRUD(){
		interestService.deleteAll();
		assertThat(interestService.getCount(), is(0L));

		interestService.add(interest);
		assertThat(interestService.getCount(), is(1L));

		Interest findInterest = interestService.selectByCategory(Interest.Category.RESTAURANT).get(0);
		assertThat(findInterest, is(interest));

		interestService.deleteById(findInterest.getId());
		assertThat(interestService.getCount(), is(0L));
	}
}
