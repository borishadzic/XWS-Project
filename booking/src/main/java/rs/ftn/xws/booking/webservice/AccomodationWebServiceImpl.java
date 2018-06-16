package rs.ftn.xws.booking.webservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.xws.booking.persistence.domain.Accomodation;
import rs.ftn.xws.booking.persistence.domain.AccomodationType;
import rs.ftn.xws.booking.persistence.domain.AdditionalService;
import rs.ftn.xws.booking.persistence.domain.Category;
import rs.ftn.xws.booking.persistence.domain.Term;
import rs.ftn.xws.booking.persistence.repository.AccomodationRepository;
import rs.ftn.xws.booking.persistence.repository.AccomodationTypeRepository;
import rs.ftn.xws.booking.persistence.repository.AdditionalServiceRepository;
import rs.ftn.xws.booking.persistence.repository.CategoryRepository;
import rs.ftn.xws.booking.persistence.repository.TermRepository;
import rs.ftn.xws.booking.service.AccomodationService;
import rs.ftn.xws.booking.xsd.AccomodationSoap;
import rs.ftn.xws.booking.xsd.AccomodationTypeSoap;
import rs.ftn.xws.booking.xsd.AdditionalServiceSoap;
import rs.ftn.xws.booking.xsd.CategorySoap;
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
	private AccomodationRepository accRepository;
	
	@Autowired
	private AccomodationTypeRepository accTypeRepository;
	
	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	
	@Autowired
	private TermRepository termRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Long addAccomodation(AccomodationSoap accomodation) {
		
		//dodatne usluge
		
		//dodatne usluge
		
		//termini
		
		
		Set<AdditionalService> services = new HashSet<AdditionalService>(additionalServiceRepository.findAllById(accomodation.getAdditionalServices()));
		//termini
		Accomodation newaccomodation = new Accomodation();
		newaccomodation.setName(accomodation.getName());
		newaccomodation.setDescription(accomodation.getDescription());
		newaccomodation.setCapacity(accomodation.getCapacity());
		newaccomodation.setAdditionalServices(services);
		newaccomodation.setAccomodationType(accTypeRepository.getOne(accomodation.getAccomodationType()));
		newaccomodation.setCity(accomodation.getCity());
		newaccomodation.setCountry(accomodation.getCountry());
		newaccomodation.setAddress(accomodation.getAddress());
		newaccomodation.setCategory(categoryRepository.getOne(accomodation.getCategory()));
		newaccomodation = accService.addAccomodation(newaccomodation);
		
		
		/*for(TermSoap termSoap : accomodation.getTerms()) {
			Term term = new Term();
			term.setStartDate(termSoap.getStartDate());
			term.setEndDate(termSoap.getEndDate());
			term.setPrice(termSoap.getPrice());
			term.setAccomodation(newaccomodation);
			termRepository.save(term);
		}*/
		
		
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
		List<AccomodationSoap> accsoap = new ArrayList<>();
		for(Accomodation acc : accRepository.findAll()) {
			AccomodationSoap accS = new AccomodationSoap();
			accS.setId(acc.getId());
			accS.setName(acc.getName());
			accS.setCountry(acc.getCountry());
			accS.setCity(acc.getCity());
			accS.setAddress(acc.getAddress());
			accS.setAccomodationType(acc.getAccomodationType().getId());
			accS.setCategory(acc.getCategory().getId());
			accS.setCapacity(acc.getCapacity());
			accS.setDescription(acc.getDescription());
			List<Long> asids = new ArrayList<>();
			for(AdditionalService as : acc.getAdditionalServices()) {
				asids.add(as.getId());
			}
			accS.setAdditionalServices((ArrayList<Long>) asids);
			
			List<TermSoap> termsSoap = new ArrayList<>();
			for(Term term : acc.getTerms()) {
				TermSoap termSoap = new TermSoap();
				termSoap.setStartDate(term.getStartDate());
				termSoap.setEndDate(term.getEndDate());
				termSoap.setPrice(term.getPrice());
				termSoap.setId(term.getId());
				termSoap.setAccomodationId(acc.getId());
				termsSoap.add(termSoap);
			}
			accS.setTerms((ArrayList<TermSoap>) termsSoap);
			
			accsoap.add(accS);
		}
		
		return accsoap;
	}
	
	@Override
	public List<AccomodationTypeSoap> getAllAccomodationTypes() {
		List<AccomodationType> types = accTypeRepository.findAll();
		List<AccomodationTypeSoap> typesSoap = new ArrayList<AccomodationTypeSoap>();
		for(AccomodationType type : types) {
			AccomodationTypeSoap typeSoap = new AccomodationTypeSoap();
			typeSoap.setId(type.getId());
			typeSoap.setType(type.getType());
			typesSoap.add(typeSoap);
		}
		return typesSoap;
	}

	@Override
	public List<AdditionalServiceSoap> getAllAdditionalServices() {
		List<AdditionalService> services = additionalServiceRepository.findAll();
		List<AdditionalServiceSoap> servicesSoap = new ArrayList<AdditionalServiceSoap>();
		for(AdditionalService service : services) {
			AdditionalServiceSoap addSoap = new AdditionalServiceSoap();
			addSoap.setId(service.getId());
			addSoap.setName(service.getName());
			servicesSoap.add(addSoap);
		}
		return servicesSoap;
	}

	@Override
	public List<CategorySoap> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		List<CategorySoap> categoriesSoap = new ArrayList<CategorySoap>();
		for(Category category : categories) {
			CategorySoap categorySoap = new CategorySoap();
			categorySoap.setId(category.getId());
			categorySoap.setCategory(category.getCategory());
			categoriesSoap.add(categorySoap);
		}
		return categoriesSoap;
	}

	@Override
	public Long creatingTerm(TermSoap termSoap, Long accDatabaseId) {
		Term term = new Term();
		term.setStartDate(termSoap.getStartDate());
		term.setEndDate(termSoap.getEndDate());
		term.setPrice(termSoap.getPrice());
		term.setAccomodation(accRepository.getOne(accDatabaseId));
		term = termRepository.save(term);
		return term.getId();
	}

}
