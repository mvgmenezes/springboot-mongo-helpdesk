package com.mmenezes.helpdesk.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mmenezes.helpdesk.api.entity.User;

public interface UserService {
	
	User findByEmail(String email);
	
	//se o id estiver preenchido vai ser alteracao
	User createOrUpdate(User user);
	
	Optional<User> findById(String id);
	
	void delete(String id);
	
	// passa a pagina que quer e count a quantidade de registro.
	Page<User> findAll(int page, int count);

}
