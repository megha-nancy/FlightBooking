package io.flightbooking.BookingService1.resource;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import io.flightbooking.BookingService1.models.BookingRecord;
import io.flightbooking.BookingService1.models.Fare;
import io.flightbooking.BookingService1.models.Passenger;
import io.flightbooking.BookingService1.repository.BookingRepository;

@RestController
@RequestMapping("/book")
public class BookingController {
       
  
	@Autowired
	private BookingRepository bookingrepo;
     RestTemplate restTemplate=new RestTemplate();
     RestTemplate restTemp=new RestTemplate();
     RestTemplate restTemp1=new RestTemplate();
 	
     @GetMapping("/list")
	public List<BookingRecord> getList(){
	return bookingrepo.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Optional<BookingRecord> getAirport(@PathVariable String id){
		return bookingrepo.findById(id);
	}
	
	
	@PostMapping("/addrecord")
	public String addBookingRecord(@RequestBody BookingRecord bookingRecord) {
	bookingrepo.save(bookingRecord);
	return "records are added";
	}	
	@PutMapping("/update/{id}")
	public String getbyId(@PathVariable String id,@RequestBody BookingRecord bookingRecord) {
	BookingRecord bookingId=bookingrepo.findById(id).get();
	bookingId.setId(bookingRecord.getId());
	bookingId.setFlightNumber(bookingRecord.getFlightNumber());
	bookingId.setOrigin(bookingRecord.getOrigin());
	bookingId.setDestination(bookingRecord.getDestination());
	bookingId.setFlightDate(bookingRecord.getFlightDate());
	bookingId.setBookingDate(bookingRecord.getBookingDate());
	bookingId.setFare(bookingRecord.getFare());
	bookingId.setStatus(bookingRecord.getStatus());
	bookingrepo.save(bookingId);
	return "updated bookingRecord";
	}



	@DeleteMapping("/delete/{id}")
	public String deletebyId(@PathVariable String id) {
	bookingrepo.deleteById(id);
	return "bookingrecord deleted with id";
	}
  
	
	//RestTemplate mapping
	
	 /*  @GetMapping("/getallflightdata")
			public Fare getfareFindAllc() {
				System.out.println("calling fare api to get fare all");
				Fare fare=restTemplate.getForObject("http://localhost:8086/fares/list",Fare.class);
				return fare; 
				
		      }*/
	
	 @GetMapping("/getflightdata/{destination}")
		public Fare getFare(@PathVariable ("destination") String destination) {
			System.out.println("calling fare api to get fare");
			Fare fare=restTemplate.getForObject("http://localhost:3333/fares/list/"+destination,Fare.class);
			return fare; 
			
	      }


	
	    @GetMapping("/getpassengerdata/{Id}")
	  	public Passenger getPassenger(@PathVariable ("Id") int Id) {
	  		System.out.println("calling passenger api to get passengerdetails");
	  		Passenger passenger=restTemp.getForObject("http://localhost:4444/passanger/findAll/" +Id ,Passenger.class);
	  		return passenger; 
	  		
	        }

	}



