package com.cafe24.sns.service;

import com.cafe24.sns.model.Interest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InterestServiceTest {
	@Autowired
	private InterestService interestService;
	private Interest interest;

	@Before
	public void setup(){
		interest = new Interest(null, Interest.Category.RESTAURANT, "신전떡볶이");
	}

	@Test
	public void testInterestCRUD(){
		assertThat(interestService.getCount(), is(0L));

		interestService.add(interest);
		assertThat(interestService.getCount(), is(1L));

		Interest findInterest = interestService.get(1L);
		assertThat(findInterest.getName(), is("신전떡볶이"));
		assertThat(findInterest, is(interest));

	}
}
