package springboot.FlightService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import springboot.FlightService.entity.Fare;

public interface FaresRepository extends MongoRepository<Fare, String> {
	Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate,String destination);

}
