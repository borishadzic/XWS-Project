package agentapp.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agentapp.domain.Accomodation;
import agentapp.domain.AdditionalService;
import agentapp.domain.Term;
import agentapp.dto.AccomodationInfo;
import agentapp.dto.TermInfo;
import agentapp.repository.AccomodationRepository;
import agentapp.repository.AccomodationTypeRepository;
import agentapp.repository.AdditionalServiceRepository;
import agentapp.repository.CategoryRepository;
import agentapp.repository.TermRepository;
import agentapp.service.AccomodationService;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationSoap;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationWebServiceSoap;
import rs.ftn.xws.booking.accomodationwebservice.TermSoap;

@RestController
@RequestMapping("/accomodations")
public class AccomodationController {
	
	@Autowired
	private AccomodationWebServiceSoap accWebService;
	
	@Autowired
	private AccomodationService accService;
	
	@Autowired
	private AdditionalServiceRepository addServiceRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AccomodationTypeRepository accTypeRepo;
	
	@Autowired
	private TermRepository termRepository;
	
	@Autowired
	private AccomodationRepository accomodationRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public Accomodation addAccomodation(@RequestBody AccomodationInfo info) throws DatatypeConfigurationException {
		System.out.println(info.getCategory());
		//soap
		AccomodationSoap accSoap = new AccomodationSoap();
		accSoap.setName(info.getName());
		accSoap.setCountry(info.getCountry());
		accSoap.setCity(info.getCity());
		accSoap.setAddress(info.getAddress());
		accSoap.setCategory(categoryRepository.getOne(info.getCategory()).getDatabaseId());
		accSoap.setAccomodationType(accTypeRepo.getOne(info.getAccomodationType()).getDatabaseId());
		accSoap.setCapacity(info.getCapacity());
		accSoap.setDescription(info.getDescription());
		
		List<Long> addservices = new ArrayList<Long>();
		List<AdditionalService> services = addServiceRepository.findAllById(info.getAdditionalServices());
		
		for(AdditionalService service : services) {
			addservices.add(service.getDatabaseId());
		}
		accSoap.setAdditionalServices(addservices);
		
		List<TermInfo> termsInfo = info.getTerms();
		List<TermSoap> termsSoap = new ArrayList<TermSoap>();
		
		for(TermInfo terminfo : termsInfo ) {
			GregorianCalendar c = new GregorianCalendar();
			
			
			TermSoap termSoap = new TermSoap();
			c.setTime(terminfo.getStartDate());
			XMLGregorianCalendar startdate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			termSoap.setStartDate(startdate);
			c.setTime(terminfo.getEndDate());
			XMLGregorianCalendar enddate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			termSoap.setEndDate(enddate);
			termSoap.setPrice(terminfo.getPrice());
			termsSoap.add(termSoap);
		}
		
		accSoap.setTerms(termsSoap);
		
		Long databaseId = accWebService.addAccomodation(accSoap);
		
		//soap
		
		//lokalno
		Accomodation acc = new Accomodation();
		
		acc.setName(info.getName());
		acc.setCountry(info.getCountry());
		acc.setCity(info.getCity());
		acc.setAddress(info.getAddress());
		acc.setCategory(categoryRepository.getOne(info.getCategory()));
		acc.setAccomodationType(accTypeRepo.getOne(info.getAccomodationType()));
		acc.setCapacity(info.getCapacity());
		acc.setDescription(info.getDescription());
		acc.setDatabaseId(databaseId);
		
		Set<AdditionalService> serviceslocal = new HashSet<AdditionalService>(addServiceRepository.findAllById(info.getAdditionalServices()));
		acc.setAdditionalServices(serviceslocal);
		accomodationRepository.save(acc);
		
		List<Term> termsLocal = new ArrayList<Term>();
		for(TermInfo termInfo : termsInfo) {
			//term soap
			GregorianCalendar c = new GregorianCalendar();
			TermSoap termSoap = new TermSoap();
			c.setTime(termInfo.getStartDate());
			XMLGregorianCalendar startdate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			termSoap.setStartDate(startdate);
			c.setTime(termInfo.getEndDate());
			XMLGregorianCalendar enddate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			termSoap.setEndDate(enddate);
			termSoap.setPrice(termInfo.getPrice());
			termSoap.setReserved(false);
			//
			Term termlocal = new Term();
			termlocal.setStartDate(termInfo.getStartDate());
			termlocal.setEndDate(termInfo.getEndDate());
			termlocal.setPrice(termInfo.getPrice());
			termlocal.setAccomodation(acc);
			termlocal.setReserved(false);
			Long id = accWebService.creatingTerm(termSoap, databaseId);
			termlocal.setDatabaseId(id);
			termRepository.save(termlocal);
			termsLocal.add(termlocal);
		}
		acc.setTerms(termsLocal);
		accomodationRepository.save(acc);
		
		//lokalno
		return acc;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Accomodation> getAllAccomodations(){
		return accomodationRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public Accomodation getAccomodationById(@PathVariable("id") Long id){
		return accomodationRepository.getOne(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public Accomodation modifyAccomodation(@RequestBody AccomodationInfo info,@PathVariable("id") Long id) throws DatatypeConfigurationException{
		//local
		Accomodation accomodation = accomodationRepository.getOne(id);
		accomodation.setName(info.getName());
		accomodation.setCountry(info.getCountry());
		accomodation.setCity(info.getCity());
		accomodation.setAddress(info.getAddress());
		accomodation.setAccomodationType(accTypeRepo.getOne(info.getAccomodationType()));
		accomodation.setCategory(categoryRepository.getOne(info.getCategory()));
		accomodation.setDescription(info.getDescription());
		accomodation.setCapacity(info.getCapacity());
		Set<AdditionalService> services = new HashSet<AdditionalService>(addServiceRepository.findAllById(info.getAdditionalServices()));
		accomodation.getAdditionalServices().clear();
		accomodation.setAdditionalServices(services);
		accomodation.getTerms().clear();
		List<Term> tempTerms = new ArrayList<>();
		for(Term term : termRepository.findAll()) {
			if(term.getAccomodation().getId() == accomodation.getId()) {
				tempTerms.add(term);
			}
		}
		
		accomodation = accomodationRepository.save(accomodation);
		
		termRepository.deleteAll(tempTerms);
		
		List<TermSoap> termsSoap = new ArrayList<>();
		
		for(TermInfo terminfo : info.getTerms()) {
			//local
			Term term = new Term();
			term.setStartDate(terminfo.getStartDate());
			term.setEndDate(terminfo.getEndDate());
			term.setPrice(terminfo.getPrice());
			term.setReserved(terminfo.isReserved());
			term.setAccomodation(accomodation);
			termRepository.save(term);
			
			//soap
			GregorianCalendar c = new GregorianCalendar();
			TermSoap termSoap = new TermSoap();
			c.setTime(terminfo.getStartDate());
			termSoap.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
			c.setTime(terminfo.getEndDate());
			termSoap.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
			termSoap.setPrice(terminfo.getPrice());
			termSoap.setReserved(terminfo.isReserved());
			termSoap.setAccomodationId(accomodation.getId());
			termsSoap.add(termSoap);
			
		}
		// local
		
		//soap
		AccomodationSoap accSoap = new AccomodationSoap();
		accSoap.setName(info.getName());
		accSoap.setCountry(info.getCountry());
		accSoap.setCity(info.getCity());
		accSoap.setAddress(info.getAddress());
		accSoap.setAccomodationType(info.getAccomodationType());
		accSoap.setCategory(info.getCategory());
		accSoap.setDescription(info.getDescription());
		accSoap.setCapacity(info.getCapacity());
		accSoap.setAdditionalServices(info.getAdditionalServices());
		accSoap.setTerms(termsSoap);
		//soap
		
		
		return accomodationRepository.save(accomodation);
	}

}
