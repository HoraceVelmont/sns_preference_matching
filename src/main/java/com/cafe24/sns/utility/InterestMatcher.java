package com.cafe24.sns.utility;

import com.cafe24.sns.model.Friendship;
import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import com.cafe24.sns.model.PersonInterest;

import java.util.*;

public class InterestMatcher {
	public static List<List<Match>> getMatchListByCategory(Person person1, Person person2,
			Interest.Category category) {
		List<List<Match>> matchList = new ArrayList<>();
		Set<Person> friends1 = person1.getFriends();
		Set<Person> friends2 = person2.getFriends();

		List<Match> match1 = getMatchByFriendships(friends1, friends2, category);
		List<Match> match2 = getMatchByFriendships(friends2, friends1, category);

		matchList.add(match1);
		matchList.add(match2);

		return matchList;
	}

	// 6촌내 친구 매칭
	private static Match getMatch6ByFriendships(Person person, Interest.Category category) {
		Queue<Match> q = new LinkedList<>();
		for (Person friend : person.getFriends())
			q.add(new Match(person, friend, 1,
					getSameInterestsCount(person, friend, category)));

		int maxCount = 0;
		Match bestMatch = null;
		Set<Person> chk = new HashSet<>();
		while (!q.isEmpty()) {
			Match match = q.poll();
			Person matchCandidate = match.getMatchFriend();
			if (match.getRelationLevel() < 6) {
				for (Person friend : matchCandidate.getFriends()) {
					Person friendCandidate = friend;
					if (!chk.contains(friendCandidate) && person.isFriend(friendCandidate)) {
						int count = getSameInterestsCount(person, friendCandidate, category);
						if (count > maxCount) {
							maxCount = count;
							bestMatch = new Match(person, friendCandidate, match.getRelationLevel() + 1, count);
						}
						q.add(new Match(person, matchCandidate, match.getRelationLevel() + 1, count));
						chk.add(matchCandidate);
					}
				}
			}
		}
		return bestMatch;
	}

	// 친구의 친구 매칭
	private static List<Match> getMatchByFriendships(Set<Person> friendships1, Set<Person> friendships2,
			Interest.Category category) {
		List<Match> matches = new ArrayList<>();
		for (Person friend1 : friendships1) {
			Person matchFriend = null;
			int maxCount = 0;
			for (Person friend2 : friendships2) {
				if (!friend1.isFriend(friend2)) {
					int count = getSameInterestsCount(friend1, friend2, category);
					if (maxCount < count) {
						maxCount = count;
						matchFriend = friend2;
					}
				}
			}
			if (matchFriend != null) {
				Match match = new Match(friend1, matchFriend, 1, maxCount);
				matches.add(match);
			}
		}
		return matches;
	}

	private static int getSameInterestsCount(Person personA, Person personB, Interest.Category interestCategory) {
		List<PersonInterest> interestListA = personA.getPersonInterestList();
		List<PersonInterest> interestListB = personB.getPersonInterestList();

		int count = 0;
		for (int i = 0; i < interestListA.size(); i++) {
			Interest interestA = interestListA.get(i).getInterest();
			for (int j = 0; j < interestListB.size(); j++) {
				Interest interestB = interestListB.get(j).getInterest();
				if (interestA.getCategory() == interestCategory && interestB.getCategory() == interestCategory)
					if (interestA.equals(interestB))
						count++;
			}
		}
		return count;
	}
}
