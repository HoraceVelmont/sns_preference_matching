package com.cafe24.sns.model;

import com.cafe24.sns.model.pk.FriendshipPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Friendship implements Serializable {
	@EmbeddedId
	private FriendshipPK id = new FriendshipPK();

	@JsonIgnore
	@ManyToOne
	@MapsId("owner_person_id")
	private Person owner;

	@JsonIgnore
	@ManyToOne
	@MapsId("friend_person_id")
	private Person friend;

	@JsonIgnore
	@Temporal(TemporalType.DATE)
	private Date date;

	public Friendship(){

	}

	public Friendship(Person owner, Person friend){
		this.owner = owner;
		this.friend = friend;
	}
}
