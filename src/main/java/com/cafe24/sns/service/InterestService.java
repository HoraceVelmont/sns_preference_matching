package com.cafe24.sns.service;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InterestService {
	@Autowired
	private InterestRepository repository;

	public Interest add(Interest interest) {
		return repository.save(interest);
	}
	public Interest get(Long id) {
		return repository.findOne(id);
	}

	public List<Interest> getByCategory(Interest.Category category) {
		return repository.findByCategory(category);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public void deleteById(Long id) {
		repository.delete(id);
	}

	public long getCount() {
		return repository.count();
	}
}
