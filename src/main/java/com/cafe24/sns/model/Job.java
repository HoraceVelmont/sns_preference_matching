package com.cafe24.sns.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Job  {
	public enum Type {
		School, Company;
	}

	public enum State{
		Attend, Leave;
	}

	@Id
	@Column(name ="job_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private State state;

	@Column
	private Type type;
}
