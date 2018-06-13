package agentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agentapp.domain.Location;
import agentapp.service.LocationService;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationWebServiceSoap;
import rs.ftn.xws.booking.test.TestServiceSoap;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestServiceSoap testService;
	
	@Autowired
	private AccomodationWebServiceSoap accWebService;
	
	@Autowired
	private LocationService locService;
	
	@GetMapping
	public String test() throws Exception {
		return testService.testMethodOne();
	}
	
	@GetMapping("/test2")
	public Long testLocation() {
		Location loc = new Location();
		loc.setCountry("Serbia");
		loc.setCity("Novi Sad");
		loc.setAddress("Radnicka");
		loc = locService.addLocation(loc);
		
		
		Long id = accWebService.addLocation(loc.getCountry(),loc.getCity(),loc.getAddress());
		
		return id;
	}
}