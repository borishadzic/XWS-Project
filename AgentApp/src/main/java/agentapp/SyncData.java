package agentapp;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agentapp.domain.AccomodationType;
import agentapp.domain.AdditionalService;
import agentapp.repository.AccomodationTypeRepository;
import agentapp.repository.AdditionalServiceRepository;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationWebServiceSoap;

@Component
public class SyncData {
	
	@Autowired
	private AccomodationWebServiceSoap accWebService;
	
	@Autowired
	private AccomodationTypeRepository accTypeRepository;
	
	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;

	@PostConstruct
	public void init() {
		
			accTypeRepository.deleteAll();
			additionalServiceRepository.deleteAll();
		
		
			List<String> typesSoap = accWebService.getAllAccomodationTypes();
			List<String> servicesSoap = accWebService.getAllAdditionalServices();
			
			for(String typeSoap : typesSoap) {
				AccomodationType type = new AccomodationType();
				type.setType(typeSoap);
				accTypeRepository.save(type);
			}
			
			for(String serviceSoap : servicesSoap) {
				AdditionalService service = new AdditionalService();
				service.setName(serviceSoap);
				additionalServiceRepository.save(service);
			}
		
	}
	
}
