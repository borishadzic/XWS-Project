package agentapp.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agentapp.domain.Accomodation;
import agentapp.dto.AccomodationInfo;

@RestController
@RequestMapping("/accomodations")
public class AccomodationController {
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public Accomodation addAccomodation(@RequestBody AccomodationInfo info) {
		System.out.println(info);
		return null;
	}

}
