package com.example.java;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public List<Ticket> getTickets(){
		return ticketRepository.findAll();
	}
	
	//
	@RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.GET)
    public Ticket getTicket(@PathVariable("ticketId") int ticketId) {
    	Ticket ticket = ticketRepository.findById(ticketId)
    			.orElseThrow(() -> new IllegalArgumentException("Invalid ticket id :" + ticketId));
    	return ticket;
    }
    
    // Add a new ticket
	@RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public Ticket addTicket(@Valid @RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    //update a ticket
	@RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.PUT)
    public void updateTicket(@PathVariable("ticketId") int ticketId,@Valid Ticket ticket) {
    	ticket.setTicketId(ticketId);
    	ticketRepository.save(ticket);
    }
    //delete a ticket
	@RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable("ticketId") int ticketId) {
    	Ticket ticket = ticketRepository.findById(ticketId)
    			.orElseThrow(() -> new IllegalArgumentException("Invalid ticket id :" + ticketId));
    	ticketRepository.delete(ticket);
    }

}
