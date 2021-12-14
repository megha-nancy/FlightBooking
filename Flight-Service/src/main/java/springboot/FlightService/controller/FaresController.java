package springboot.FlightService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



//import io.flightbooking.BookingService1.models.BookingRecord;
import springboot.FlightService.entity.Fare;
/*
import io.flightbooking.BookingService1.models.BookingRecord;
import springboot.FlightService.controller.component.FaresComponent;
import springboot.FlightService.entity.Fare;*/
import springboot.FlightService.repository.FaresRepository;

@RestController
@CrossOrigin
@RequestMapping("/fares")
public class FaresController {
	//FaresComponent faresComponent;
	
	@Autowired
	FaresRepository faresRepository;
	

	@GetMapping("/list")
	public List<Fare> getList(){
	return faresRepository.findAll();
	}
	/*@GetMapping("/find/{id}")
	public Optional<Fare> getAirport(@PathVariable String id){
		return faresRepository.findById(id);
	}*/
	
	@PostMapping("/addrecord")
	public String addfareRecord(@RequestBody Fare fare) {
		faresRepository.save(fare);
	return "records are added";
	}
	@GetMapping("/list/{destination}")
	public Optional<Fare> getFare(@PathVariable("destination") String destination){
	return faresRepository.findById(destination); 
	}
	
}

