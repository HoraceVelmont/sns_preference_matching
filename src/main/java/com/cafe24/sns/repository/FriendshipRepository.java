package com.cafe24.sns.repository;

import com.cafe24.sns.model.Friendship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {
	Friendship findById(Long id);
}
