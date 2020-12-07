package com.example.java;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.domain.AfterDomainEventPublication;

import io.micrometer.core.annotation.Counted;

@Entity
@Table(name = "customers")
public class Customer {

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int custId,
			@NotNull(message = "Pleas enter your name") @Pattern(regexp = "^[A-Za-z]*$", message = "Non-Numeric values only") @Size(min = 4, max = 40) String custName,
			@NotNull(message = "Please enter your address") @Size(min = 6, max = 50) String address,
			@NotNull(message = "Please enter your city") @Size(min = 4, max = 30) String city,
			@NotNull(message = "Please enter your email") @Email @Size(min = 4, max = 50) String email,
			@NotNull(message = "Please enter your phoneNumber") @Pattern(regexp = "(^$|[0-9]{10})", message = "Please enter 10 numeric values") @Size(min = 10, max = 10) String phoneNumber) {
		this.custId = custId;
		this.custName = custName;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int custId;
	
	@NotEmpty(message = "Pleas enter your name")
	@NotNull(message = "Pleas enter your name")
	@Pattern(regexp="^[A-Za-z]*$",message = "Non-Numeric values only")
	@Size(min=4,max = 40)
	@Column(name="cust_Name")
	private String custName;
	
	@NotEmpty(message = "Please enter your address")
	@NotNull(message = "Please enter your address")
	@Size(min = 6, max = 50)
	@Column(name="address")
	private String address;
	
	@NotEmpty(message = "Please enter your city")
	@NotNull(message = "Please enter your city")
	@Size(min = 4,max = 30)
	@Column(name = "city")
	private String city;
	
	@NotEmpty(message = "Please enter your email")
	@NotNull(message = "Please enter your email")
	@Email
	@Size(min = 4,max = 50)
	@Column(name = "email")
	private String email;
	
	@NotEmpty(message = "Please enter your phoneNumber")
	@NotNull(message = "Please enter your phoneNumber")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Please enter 10 numeric values")
	@Size(min = 10,max = 10)
	@Column(name = "phone_number")
	private String phoneNumber;
	

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", address=" + address + ", city=" + city
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
