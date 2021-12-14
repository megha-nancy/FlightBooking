package io.flightbooking.BookingService1.models;

import org.springframework.data.annotation.Id;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import org.springframework.data.mongodb.core.mapping.Document;


//@Entity
@Document(collection="FlightDetails")
public class Fare {
	@Id
	String destination;
	String origin;
	  String id;
	String flightNumber;
	String flightDate;
	
	
	
  	
	public Fare() {
		super();
	}


	public Fare(String id, String flightNumber, String flightDate, String origin, String destination) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.origin = origin;
		this.destination = destination;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getFlightDate() {
		return flightDate;
	}


	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	@Override
	public String toString() {
		return "Fare [id=" + id + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", origin=" + origin
				+ ", destination=" + destination + "]";
	}


	}