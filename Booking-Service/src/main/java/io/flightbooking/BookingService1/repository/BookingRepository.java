package io.flightbooking.BookingService1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.flightbooking.BookingService1.models.BookingRecord;
import io.flightbooking.BookingService1.models.Fare;

public interface BookingRepository extends MongoRepository<BookingRecord,String> {
	Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate,String destination);

}
