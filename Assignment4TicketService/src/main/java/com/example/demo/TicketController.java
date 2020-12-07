package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		return index();
	}

	@GetMapping(value = { "/", "/index" })
	public ModelAndView index() {
		List<Ticket> tickets = ticketRepository.findAll();
		ModelAndView model = new ModelAndView();
		model.addObject("tickets", tickets);
		model.addObject("title", "Home-Page");
		model.setViewName("index");
		return model;
	}

	@GetMapping("tickets/{id}")
	public String getTicket(@PathVariable("id") int ticketId, Model model) {
		Ticket ticket = ticketRepository.getOne(ticketId);
		if (ticket != null) {
			model.addAttribute("ticket", ticket);
			model.addAttribute("ticketId", ticketId);
			return "ticket-details";
		} else {
			return "error";
		}
	}

	@GetMapping(value = "/addTicketForm")
	public String addTicketForm(Ticket ticket,Model model) {
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("title", "Add-Ticket");
		return "add-ticket";
	}

	@PostMapping(value = "/addTicket")
	public ModelAndView addTicket(@Valid Ticket ticket, BindingResult result, ModelAndView model) {
		if (result.hasErrors()) {
			model.addObject("ticket",ticket);
			model.setViewName("add-ticket");
			return model;
		}
		try {
			ticketRepository.save(ticket);
			return index();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String messageString = e.getMessage();
			model.addObject("message", messageString);
			model.setViewName("add-ticket");
			return model;
		}
	}

	@GetMapping("/update/{id}")
	public String updateTicketPage(@PathVariable("id") int ticketId, Model model) {

		model.addAttribute("ticket", ticketRepository.getOne(ticketId));
		model.addAttribute("ticketId", ticketId);
		model.addAttribute("title", "Update Ticket");
		return "update-ticket";
	}

	@PostMapping(value = "/update/{id}")
	public ModelAndView updateTicket(@PathVariable("id") int ticketId, @Valid Ticket ticket,
			BindingResult result, ModelAndView model){
		if (result.hasErrors()) {
			model.addObject("ticket",ticket);
			model.addObject("ticketId", ticketId);
			model.setViewName("update-ticket");	
			model.addObject("message", result.getAllErrors());
			return model;		
			}
		try {
			ticket.setTicketId(ticketId);
			ticketRepository.save(ticket);
		} catch (Exception e) {
			model.addObject("message", e.getMessage());
			model.addObject("ticket",ticket);
			model.addObject("ticketId", ticketId);
			model.setViewName("update-ticket");
		}

		return index();
	}

	@GetMapping(value = "/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView deleteTicket(@PathVariable("id") int ticketId) throws Exception {
		ticketRepository.deleteById(ticketId);
		return index();
	}
}
