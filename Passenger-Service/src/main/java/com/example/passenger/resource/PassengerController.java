package com.example.passenger.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.passenger.models.Passenger;
import com.example.passenger.repository.PassengerRepository;


@RestController
@RequestMapping("/passanger")
public class PassengerController {
	@Autowired
	private PassengerRepository passrep;
	@GetMapping("/list")
	public List<Passenger> getList(){
	return passrep.findAll();
	}


	@PostMapping("/addrecord")
	public String addPassengerData(@RequestBody Passenger passengerRecord) {
		passrep.save(passengerRecord);
	return "records are added";
	}

	
	@GetMapping("/findAll/{id}")
	public Optional<Passenger> getAirport(@PathVariable int id){
		return passrep.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAirport(@PathVariable int id) {
		passrep.deleteById(id);
		return "Book deleted with id : "+id;
		
	}
	
	
	}


