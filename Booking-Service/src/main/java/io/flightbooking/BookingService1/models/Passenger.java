package io.flightbooking.BookingService1.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import java.sql.Date;
@Document(collection="PassengerData")
public class Passenger {
	@Id
int id;
    
    String lastName;
    String firstName;
    String seatNumber;
    String checkInTime;
    String flightNumber;
    String flightDate;
    long bookingId;
    
    public Passenger() {}
	public Passenger(String lastName, String firstName, String seatNumber, String checkInTime, String flightNumber,
			String flightDate, long bookingId) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.seatNumber = seatNumber;
		this.checkInTime = checkInTime;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.bookingId = bookingId;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
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
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", seatNumber="
				+ seatNumber + ", checkInTime=" + checkInTime + ", flightNumber=" + flightNumber + ", flightDate="
				+ flightDate + ", bookingId=" + bookingId + "]";
	}
    
    

}
