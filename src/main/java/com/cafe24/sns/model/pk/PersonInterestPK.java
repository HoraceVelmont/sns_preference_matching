package com.cafe24.sns.model.pk;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PersonInterestPK implements Serializable {
	@Column(name = "interest")
	protected Long interest;

	@Column(name = "person")
	protected Long person;
}
