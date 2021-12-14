package com.airport.resource;

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
import org.springframework.web.client.RestTemplate;

import com.airport.model.Airport;
import com.airport.model.Fare;
import com.airport.repository.AirportRepository;

@RestController
@RequestMapping("/airport")
public class AirportController {

	@Autowired
	private AirportRepository repository;
	RestTemplate restTemplate=new RestTemplate();
	
	@GetMapping("/hello")
	public String printHello() {
		return "Hello Passenger";
	}
	
	@PostMapping("/add")
	public String saveAirport(@RequestBody Airport airport) {
		repository.save(airport);
		return "Added airport with id : "+airport.getAirportId();
	}
	
	@GetMapping("/findAll")
	public List<Airport> getAirports(){
		return repository.findAll();
	}
	
	@GetMapping("/findAll/{id}")
	public Optional<Airport> getAirport(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAirport(@PathVariable int id) {
		repository.deleteById(id);
		return "Book deleted with id : "+id;
		
	}
	@RequestMapping("/getflightdata/{destination}")
	public Fare getFlightDetails(@PathVariable String destination){
		System.out.println("calling flight details from airport");
  		Fare fare= restTemplate.getForObject("http://localhost:3333/fare/get/"+ destination, Fare.class);
  		return fare;
	}
	
	
}
