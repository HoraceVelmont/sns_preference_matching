package com.cafe24.sns.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

	@Column
	private String imageUrl;


	@OneToOne
	@JoinColumn(name ="job_id")
	private Job job;

	@OneToMany(mappedBy = "person")
	private List<PersonInterest> personInterestList = new ArrayList<>();

	// Default constructor is needed
	public Person(){

	}

	public Person(String name, int age, String imageUrl, Job job) {
		this.name = name;
		this.age = age;
		this.imageUrl = imageUrl;
		this.job = job;
	}

	public Person(String name, int age, String imageUrl){
		this.name = name;
		this.age = age;
		this.imageUrl = imageUrl;
	}

	public void addPersonInterest(PersonInterest personInterest) {
		this.getPersonInterestList().add(personInterest);
	}
}
