package com.mmenezes.helpdesk.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.mmenezes.helpdesk.api.entity.ChangeStatus;
import com.mmenezes.helpdesk.api.entity.Ticket;

@Component
public interface TicketService {

	
	
	Ticket createOrUpdate(Ticket ticket);
	
	Optional<Ticket> findById(String id);
	
	void delete(String id);
	
	Page<Ticket> listTicket(int page, int count);
	
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);
	
	Iterable<ChangeStatus> listChangeStatus(String ticketId);
	
	//quando o cliente esta pesquisando a lista de ticket, ele vai pesquisar somente os ticket dele
	Page<Ticket> findByCurrentUser(int page, int count, String id);
	
	Page<Ticket> findByParameters(int page, int count, String title, String status, String priority);
	
	//Filtra somente os tickets dele
	Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority);
	
	Page<Ticket> findByNumber(int page, int count, Integer number);
	
	Iterable<Ticket> findAll();
	
	Page<Ticket> findByParameterAndAssignedUser(int page, int count, String title, String status, String priority, String assignedUser);
}
