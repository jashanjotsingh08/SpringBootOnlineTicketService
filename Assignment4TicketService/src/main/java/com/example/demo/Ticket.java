package com.example.demo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tickets")
public class Ticket {

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	@NotNull(message = "Please enter name of the movie")
	@Column(name = "movie_name")
	private String movieName;
	
	
	@NotNull(message = "Please enter the date")
	@NotBlank(message = "Please enter the date")
	@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$",message = "Must match yyyy-mm-dd format")
	@Column(name = "date")
	private String date;
	
	
	@NotNull
	@Pattern(regexp="(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9])",message = "Must match HH:mm format")
	@NotBlank(message = "Please enter the time")
	@Column(name = "time")
	private String time;
	
	@NotNull
	@NotBlank(message = "Please enter the venue")
	@Column(name = "venue")
	private String venue;
	
	@NotNull
	@NotBlank(message = "Please enter your name")
	@Column(name = "cust_name")
	private String custName;
	
	
	@Column(name = "amount_paid")
	private String amountPaid;

	@NotNull
	@NotBlank(message = "Please enter the number of seats you want")
	@Column(name = "quantity")
	private String quantity;
	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}




	
	public Ticket(int ticketId, @NotNull(message = "Please enter name of the movie") String movieName,
			@NotNull(message = "Please enter the date") String date,
			@NotNull(message = "Please enter the time") String time,
			@NotNull(message = "Please enter the venue") String venue,
			@NotNull(message = "Please enter your name") String custName,
			@NotBlank(message = "Please enter the number of seats you want") String quantity) {
		super();
		this.ticketId = ticketId;
		this.movieName = movieName;
		this.date = date;
		this.time = time;
		this.venue = venue;
		this.custName = custName;
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", movieName=" + movieName + ", date=" + date + ", time=" + time
				+ ", venue=" + venue + ", custName=" + custName + ", amountPaid=" + amountPaid + ", quantity="
				+ quantity + "]";
	}


	


	
}