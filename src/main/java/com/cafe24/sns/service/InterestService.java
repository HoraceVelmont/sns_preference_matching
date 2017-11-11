package com.cafe24.sns.service;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestService {
	@Autowired
	private InterestRepository repository;

	public Interest add(Interest interest){
		return repository.save(interest);
	}

	public Interest selectByInterestId(Long id){
		return repository.findById(id);
	}

	public List<Interest> selectByCategory(Interest.Category category){
		return repository.findByCategory(category);
	}

	public void deleteAll(){
		repository.deleteAll();
	}

	public void deleteById(Long id){
		repository.delete(id);
	}

	public long getCount(){
		return repository.count();
	}
}
