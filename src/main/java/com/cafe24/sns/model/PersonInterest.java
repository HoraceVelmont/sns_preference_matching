package com.cafe24.sns.model;

import com.cafe24.sns.model.pk.PersonInterestPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class PersonInterest implements Serializable {
	@EmbeddedId
	private PersonInterestPK id = new PersonInterestPK();

	@ManyToOne
	@MapsId("interest")
	private Interest interest;

	@ManyToOne
	@MapsId("person")
	@JsonIgnore
	private Person person;


	public void setPersonInterest(Person person, Interest interest){
		this.person = person;
		this.interest = interest;
		person.addPersonInterest(this);
	}
}
