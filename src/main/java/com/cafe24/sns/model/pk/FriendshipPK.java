package com.cafe24.sns.model.pk;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class FriendshipPK implements Serializable{
	@Column(name = "owner_person_id")
	protected Long ownerId;

	@Column(name = "friend_person_id")
	protected Long friendId;
}