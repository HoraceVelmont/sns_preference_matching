package com.cafe24.sns.utility;

import com.cafe24.sns.model.Person;
import lombok.Data;

@Data
public class Match {
	private Person owner;
	private Person matchFriend;
	private int relationLevel;
	private int interestCount;

	public Match(Person owner, Person matchFriend, int relationLevel, int interestCount) {
		this.owner = owner;
		this.matchFriend = matchFriend;
		this.relationLevel = relationLevel;
		this.interestCount = interestCount;
	}
}
