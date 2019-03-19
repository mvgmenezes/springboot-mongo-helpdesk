package com.mmenezes.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmenezes.helpdesk.api.entity.User;

public interface UserRespository extends MongoRepository<User, String>{

	User findByEmail(String email);
}
