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

	  
	  
	@GetMapping("/list")
	public List<Airport> getList(){
	return repository.findAll();
	}
	@PostMapping("/addrecord")
	public String addAirport(@RequestBody Airport airport) {
	repository.save(airport);

	
	
	return "records are added";
	}
	
	
	@GetMapping("/list/{id}")
	public Optional<Airport> getAirport(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAirport(@PathVariable int id) {
		repository.deleteById(id);
		return "Book deleted with id : "+id;
		
}
	
	
	@GetMapping("/flight/{destination}")
	public Fare getFare(@PathVariable ("destination") String destination) {
		System.out.println("calling fare api to get fare");
		Fare fare=restTemplate.getForObject("http://localhost:3333/fares/list/" +destination ,Fare.class);
		return fare; 
		
      }
		 
	//MANSI
	/*@GetMapping("/find")
	public Fare getAllFare() {
	return restTemplate.getForObject("http://localhost:8086/fares/list", Fare.class);
	}*/

       /*   @PostMapping("/add")
	public Fare addFare(@RequestBody Fare fare1) {
		
		Fare fare=restTemplate.postForObject("http://localhost:8086/fares/addrecord", fare1, Fare.class);
		return fare; 
	}*/
	
   /*  @PostMapping("/add")
	  public Fare addFare(@RequestBody Fare fare) {
		return restTemplate.postForObject("http://localhost:8086/fares/addrecord", fare, Fare.class);
	}
	*/

	
	
}
