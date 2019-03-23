package com.mmenezes.helpdesk.api.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmenezes.helpdesk.api.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String>{

	//realiza o filtro pelo o objeto User pelo atributo Id (findByUserId) e realiza a ordenaçao
	//pelo o atributo Date da classe ticket. 
	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId);
	
	//Containing  = equivalente ao Like do sql.
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingOrderByDateDesc(
			String title, String status, String priority, Pageable pages);
	
	//lista somente os tickets do usuario logado parametro userId no final do nome do metodo
	//Containing  = equivalente ao Like do sql.
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndUserIdOrderByDateDesc(
			String title, String status, String priority, String userId, Pageable pages);
	
	//lista somente os tickets de um cliente parametro AssignedUser no final do nome do metodo
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndAssignedUserIdOrderByDateDesc(
				String title, String status, String priority, Pageable pages);
		
	Page<Ticket> findByNumber(Integer number, Pageable pages);
		
}
