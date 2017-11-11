package com.cafe24.sns.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Interest {
	public enum Category {
		RESTAURANT, MOVIE, MUSIC;
	}

	@Id
	@Column(name ="interest_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private Category category;

	@Column(length = 55, nullable = false)
	private String name;

	public boolean equals(Object o){
		Interest i = (Interest)o;
		if(this.id == i.id)
			return true;
		return false;
	}
	public Interest(String name, Category category){
		this.name = name;
		this.category = category;
	}

	public Interest(){

	}
}

