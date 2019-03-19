package com.mmenezes.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmenezes.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRespository extends MongoRepository<ChangeStatus, String>{
	
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

}
