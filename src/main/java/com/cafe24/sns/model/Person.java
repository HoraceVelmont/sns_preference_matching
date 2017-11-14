package com.cafe24.sns.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private int age;

	@Column
	private String imageUrl;

	@Column(length = 30, nullable = false)
	private String name;

	@OneToOne
	@JoinColumn(name ="job_id")
	private Job job;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="friend_relation", joinColumns = {@JoinColumn(name="owner_id")}, inverseJoinColumns = {@JoinColumn(name="friend_id")})
	private Set<Person> friends = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "friends", fetch = FetchType.LAZY)
	private Set<Person> friendsWith;

	@OneToMany(mappedBy = "person",  fetch = FetchType.EAGER)
	private List<PersonInterest> personInterestList = new ArrayList<>();

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

	public boolean isFriend(Person person){
		return friends.contains(person);
	}

	public void addPersonInterest(PersonInterest personInterest) {
		this.getPersonInterestList().add(personInterest);
		personInterest.setPerson(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;

		Person person = (Person) o;

		if (age != person.age)
			return false;
		if (!id.equals(person.id))
			return false;
		if (imageUrl != null ? !imageUrl.equals(person.imageUrl) : person.imageUrl != null)
			return false;
		if (name != null ? !name.equals(person.name) : person.name != null)
			return false;
		if (job != null ? !job.equals(person.job) : person.job != null)
			return false;
		if (friends != null ? !friends.equals(person.friends) : person.friends != null)
			return false;
		if (friendsWith != null ? !friendsWith.equals(person.friendsWith) : person.friendsWith != null)
			return false;
		return personInterestList != null ?
				personInterestList.equals(person.personInterestList) :
				person.personInterestList == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + id.hashCode();
		return result;
	}
}
