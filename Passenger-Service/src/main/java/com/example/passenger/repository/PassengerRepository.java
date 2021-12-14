package com.example.passenger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.passenger.models.Passenger;



public interface PassengerRepository extends MongoRepository<Passenger,Integer> {

}
