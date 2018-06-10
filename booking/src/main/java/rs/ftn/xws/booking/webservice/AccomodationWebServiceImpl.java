package rs.ftn.xws.booking.webservice;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.xws.booking.domain.Accomodation;
import rs.ftn.xws.booking.domain.AccomodationType;
import rs.ftn.xws.booking.domain.AdditionalService;
import rs.ftn.xws.booking.domain.Location;
import rs.ftn.xws.booking.domain.Term;
import rs.ftn.xws.booking.persistence.repository.AccomodationTypeRepository;
import rs.ftn.xws.booking.persistence.repository.AdditionalServiceRepository;
import rs.ftn.xws.booking.persistence.repository.LocationRepository;
import rs.ftn.xws.booking.persistence.repository.TermRepository;
import rs.ftn.xws.booking.service.AccomodationService;
import rs.ftn.xws.booking.xsd.AccomodationSoap;
import rs.ftn.xws.booking.xsd.AdditionalServiceSoap;
import rs.ftn.xws.booking.xsd.LocationSoap;
import rs.ftn.xws.booking.xsd.TermSoap;

@Service
@WebService(endpointInterface = "rs.ftn.xws.booking.webservice.AccomodationWebService",
			serviceName = "AccomodationWebService",
			portName = "AccomodationWebServicePort",
			targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService")
public class AccomodationWebServiceImpl implements AccomodationWebService{
	
	@Autowired
	private AccomodationService accService;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private AccomodationTypeRepository accTypeRepository;
	
	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	
	@Autowired
	private TermRepository termRepository;
	
	@Override
	public Long addAccomodation(AccomodationSoap accomodation) {
		//lokacija
		Location location = new Location();
		location.setCountry(accomodation.getLocation().getCountry());
		location.setCity(accomodation.getLocation().getCity());
		location.setAddress(accomodation.getLocation().getAddress());
		location = locationRepository.save(location);
		//lokacija
		//tip
		AccomodationType acctype = new AccomodationType();
		acctype.setType(accomodation.getAccomodationType().getType());
		acctype = accTypeRepository.save(acctype);
		//tip
		//dodatne usluge
		Set<AdditionalService> additionalServices = new LinkedHashSet<AdditionalService>();
		for(AdditionalServiceSoap ass : accomodation.getAdditionalServices()) {
			AdditionalService additionalService = new AdditionalService();
			additionalService.setName(ass.getName());
			additionalService = additionalServiceRepository.save(additionalService);
			additionalServices.add(additionalService);
		}
		//dodatne usluge
		//termini
		Set<Term> terms = new LinkedHashSet<Term>();
		for(TermSoap termSoap : accomodation.getTerms()) {
			Term term = new Term();
			term.setStartDate(termSoap.getStartDate());
			term.setEndDate(termSoap.getEndDate());
			term.setPrice(termSoap.getPrice());
			term = termRepository.save(term);
			terms.add(term);
		}
		//termini
		Accomodation newaccomodation = new Accomodation();
		newaccomodation.setDescription(accomodation.getDescription());
		newaccomodation.setCapacity(accomodation.getCapacity());
		newaccomodation.setAdditionalServices(additionalServices);
		newaccomodation.setTerms(terms);
		newaccomodation.setLocation(location);
		newaccomodation.setAccomodationType(acctype);
		newaccomodation = accService.addAccomodation(newaccomodation);
		
		return newaccomodation.getId();
	}

	@Override
	public Long modifyAccomodation(AccomodationSoap accomodation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteAccomodation(Long accomodationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccomodationSoap> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addLocation(LocationSoap location) {
		Location newlocation = new Location();
		newlocation.setCountry(location.getCountry());
		newlocation.setCity(location.getCity());
		newlocation.setAddress(location.getAddress());
		newlocation = locationRepository.save(newlocation);
		return newlocation.getId();
	}

}
