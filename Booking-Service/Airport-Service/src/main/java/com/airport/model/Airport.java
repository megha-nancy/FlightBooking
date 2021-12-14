package com.airport.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Airport")
public class Airport {

	@Id
	private int airportId;
	private String airportName;
	private String airportLocation;
	public Airport(int airportId, String airportName, String airportLocation) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	public int getAirportId() {
		return airportId;
	}
	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation + "]";
	}
}
	
