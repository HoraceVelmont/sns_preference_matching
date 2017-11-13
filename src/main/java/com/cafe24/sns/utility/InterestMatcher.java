package com.cafe24.sns.utility;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import com.cafe24.sns.model.PersonInterest;

import java.util.List;

public class InterestMatcher {
	public static int getSameInterestsCount(Person personA, Person personB, Interest.Category interestCategory) {
		List<PersonInterest> interestListA = personA.getPersonInterestList();
		List<PersonInterest> interestListB = personB.getPersonInterestList();

		int count = 0;
		for (int i=0; i<interestListA.size();i++) {
			Interest interestA = interestListA.get(i).getInterest();
			for (int j=0;j<interestListB.size();j++) {
				Interest interestB = interestListB.get(j).getInterest();
				if (interestA.getCategory() == interestCategory && interestB.getCategory() == interestCategory)
					if (interestA.equals(interestB))
						count++;
			}
		}
		return count;
	}
}
