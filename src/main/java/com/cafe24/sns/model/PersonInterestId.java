package com.cafe24.sns.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonInterestId implements Serializable {
	private Long interest;
	private Long person;

	public PersonInterestId(){

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;

		PersonInterestId that = (PersonInterestId) o;

		if (interest != null ? !interest.equals(that.interest) : that.interest != null)
			return false;
		return person != null ? person.equals(that.person) : that.person == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (interest != null ? interest.hashCode() : 0);
		result = 31 * result + (person != null ? person.hashCode() : 0);
		return result;
	}
}
