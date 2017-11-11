package com.cafe24.sns.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@IdClass(PersonInterestId.class)
public class PersonInterest {
	@Id
	@GeneratedValue
	@Column(name ="person_interest_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "interest_id")
	private Interest interest;

	@ManyToOne
	@JoinColumn(name ="person_id")
	private Person person;

	private Date date;
}
