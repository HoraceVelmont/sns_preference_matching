package com.cafe24.sns.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Person {
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private int age;

	@Column(length = 30, nullable = false)
	private String name;

	@OneToMany(mappedBy = "person")
	private List<PersonInterest> personInterestList = new ArrayList<>();

	public Person() {
	}

	public void addPersonInterest(PersonInterest personInterest) {
		this.getPersonInterestList().add(personInterest);
	}
}
