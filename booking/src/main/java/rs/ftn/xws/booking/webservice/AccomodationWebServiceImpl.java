package rs.ftn.xws.booking.webservice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.xws.booking.persistence.domain.Accomodation;
import rs.ftn.xws.booking.persistence.domain.AccomodationType;
import rs.ftn.xws.booking.persistence.domain.AdditionalService;
import rs.ftn.xws.booking.persistence.domain.Term;
import rs.ftn.xws.booking.persistence.repository.AccomodationTypeRepository;
import rs.ftn.xws.booking.persistence.repository.AdditionalServiceRepository;
import rs.ftn.xws.booking.persistence.repository.TermRepository;
import rs.ftn.xws.booking.service.AccomodationService;
import rs.ftn.xws.booking.xsd.AccomodationSoap;
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
	private AccomodationTypeRepository accTypeRepository;
	
	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	
	@Autowired
	private TermRepository termRepository;
	
	@Override
	public Long addAccomodation(AccomodationSoap accomodation) {
		//lokacija
		//tip
		AccomodationType acctype = new AccomodationType();
		acctype.setType(accomodation.getAccomodationType());
		acctype = accTypeRepository.save(acctype);
		//tip
		//dodatne usluge
		Set<AdditionalService> additionalServices = new LinkedHashSet<AdditionalService>();
		for(String ass : accomodation.getAdditionalServices()) {
			AdditionalService additionalService = new AdditionalService();
			additionalService.setName(ass);
			additionalService = additionalServiceRepository.save(additionalService);
			additionalServices.add(additionalService);
		}
		//dodatne usluge
		//termini
		List<Term> terms = new ArrayList<Term>();
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
		newaccomodation.setAccomodationType(acctype);
		newaccomodation.setCity(accomodation.getCity());
		newaccomodation.setCountry(accomodation.getCountry());
		newaccomodation.setAddress(accomodation.getAddress());
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
	public List<String> getAllAccomodationTypes() {
		List<AccomodationType> types = accTypeRepository.findAll();
		List<String> typesSoap = new ArrayList<String>();
		for(AccomodationType type : types) {
			typesSoap.add(type.getType());
		}
		return typesSoap;
	}

	@Override
	public List<String> getAllAdditionalServices() {
		List<AdditionalService> services = additionalServiceRepository.findAll();
		List<String> servicesSoap = new ArrayList<String>();
		for(AdditionalService service : services) {
			servicesSoap.add(service.getName());
		}
		return servicesSoap;
	}

}
