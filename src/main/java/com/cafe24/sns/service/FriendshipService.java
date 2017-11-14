package com.cafe24.sns.service;

import com.cafe24.sns.model.Friendship;
import com.cafe24.sns.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendshipService {
	@Autowired
	private FriendshipRepository repository;

	public Friendship add(Friendship friendship){
		return repository.save(friendship);
	}
}
