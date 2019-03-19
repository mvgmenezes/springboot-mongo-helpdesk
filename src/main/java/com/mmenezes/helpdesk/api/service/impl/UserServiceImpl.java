package com.mmenezes.helpdesk.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmenezes.helpdesk.api.entity.User;
import com.mmenezes.helpdesk.api.repository.UserRespository;
import com.mmenezes.helpdesk.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRespository userRepository;

	@Override
	public User findByEmail(String email) {
		
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		//se o id estiver preenchido ele faz o update
		return this.userRepository.save(user);
	}

	@Override
	public Optional<User> findById(String id) {
		return this.userRepository.findById(id);
	}

	@Override
	public void delete(String id) {
		this.userRepository.deleteById(id);
		
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.userRepository.findAll(pages);
	}

}
