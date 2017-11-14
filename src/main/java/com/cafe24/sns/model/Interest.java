package com.cafe24.sns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Interest {
	public enum Category {
		RESTAURANT, MOVIE, MUSIC;
	}

	@Id
	@Column(name = "interest_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private Category category;

	@Column(length = 55, nullable = false)
	private String name;

	public Interest(Long id, Category category, String name){
		this.id = id;
		this.category = category;
		this.name = name;
	}
}

