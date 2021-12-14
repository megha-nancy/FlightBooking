package com.airport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airport.model.Airport;

public interface AirportRepository extends MongoRepository<Airport,Integer>{
	

}
