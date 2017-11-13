package com.cafe24.sns.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@IdClass(PersonInterestId.class)
public class PersonInterest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="person_interest_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "interest")
	private Interest interest;

	@ManyToOne
	@JoinColumn(name ="person")
	@JsonIgnore
	private Person person;
}
