package rs.ftn.xws.booking;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ftn.xws.booking.persistence.domain.AccomodationType;
import rs.ftn.xws.booking.persistence.domain.AdditionalService;
import rs.ftn.xws.booking.persistence.repository.AccomodationTypeRepository;
import rs.ftn.xws.booking.persistence.repository.AdditionalServiceRepository;

@Component
public class TestData {
	
	@Autowired
	private AccomodationTypeRepository accTypeRepository;
	
	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	
	@PostConstruct
	public void init() {
		
		if(accTypeRepository.findAll().size() == 0) {
		
			AccomodationType at1 = new AccomodationType("hotel");
			AccomodationType at2 = new AccomodationType("bed&breakfast");
			AccomodationType at3 = new AccomodationType("apartment");
			
			accTypeRepository.save(at1);
			accTypeRepository.save(at2);
			accTypeRepository.save(at3);
			
			
			AdditionalService as1 = new AdditionalService("Parking");
			AdditionalService as2 = new AdditionalService("WiFi");
			AdditionalService as3 = new AdditionalService("Breakfast");
			AdditionalService as4 = new AdditionalService("Polupansion");
			AdditionalService as5 = new AdditionalService("Pansion");
			AdditionalService as6 = new AdditionalService("TV");
			AdditionalService as7 = new AdditionalService("Mini kuhinja/kuhinja");
			AdditionalService as8 = new AdditionalService("Privatno kupatilo");
			
			additionalServiceRepository.save(as1);
			additionalServiceRepository.save(as2);
			additionalServiceRepository.save(as3);
			additionalServiceRepository.save(as4);
			additionalServiceRepository.save(as5);
			additionalServiceRepository.save(as6);
			additionalServiceRepository.save(as7);
			additionalServiceRepository.save(as8);
		
		}
		
		
	}
	
	
}
