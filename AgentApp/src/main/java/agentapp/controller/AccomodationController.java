package agentapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import agentapp.SyncData;
import agentapp.domain.Accomodation;
import agentapp.domain.AdditionalService;
import agentapp.domain.Message;
import agentapp.domain.Term;
import agentapp.dto.AccomodationInfo;
import agentapp.dto.CommentInfo;
import agentapp.dto.ImagesInfo;
import agentapp.dto.InputStreamDataSource;
import agentapp.dto.MessageInfo;
import agentapp.dto.TermInfo;
import agentapp.repository.AccomodationRepository;
import agentapp.repository.AccomodationTypeRepository;
import agentapp.repository.AdditionalServiceRepository;
import agentapp.repository.CategoryRepository;
import agentapp.repository.MessageRepository;
import agentapp.repository.TermRepository;
import agentapp.repository.UserRepository;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationSoap;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationWebServiceSoap;
import rs.ftn.xws.booking.accomodationwebservice.AgentCommentSoap;
import rs.ftn.xws.booking.accomodationwebservice.MessageSoap;
import rs.ftn.xws.booking.accomodationwebservice.TermSoap;
import rs.ftn.xws.booking.accomodationwebservice.UploadModelXsd;

@RestController
@RequestMapping("/accomodations")
public class AccomodationController {

	@Autowired
	private AccomodationWebServiceSoap accWebService;

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

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SyncData syncData;

	@PostMapping
	public Accomodation addAccomodation(@RequestBody AccomodationInfo info) throws DatatypeConfigurationException {
		System.out.println(info.getCategory());
		// soap
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

		for (AdditionalService service : services) {
			addservices.add(service.getDatabaseId());
		}
		accSoap.setAdditionalServices(addservices);

		List<TermInfo> termsInfo = info.getTerms();
		List<TermSoap> termsSoap = new ArrayList<TermSoap>();

		for (TermInfo terminfo : termsInfo) {
			GregorianCalendar c = new GregorianCalendar();

			TermSoap termSoap = new TermSoap();
			c.setTime(terminfo.getStartDate());
			XMLGregorianCalendar startdate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			termSoap.setStartDate(startdate);
			c.setTime(terminfo.getEndDate());
			XMLGregorianCalendar enddate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			termSoap.setEndDate(enddate);
			termSoap.setPrice(terminfo.getPrice());
			termSoap.setVisited(terminfo.isVisited());
			termsSoap.add(termSoap);
		}

		accSoap.setTerms(termsSoap);

		Long databaseId = accWebService.addAccomodation(accSoap);

		// soap

		// lokalno
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

		Set<AdditionalService> serviceslocal = new HashSet<AdditionalService>(
				addServiceRepository.findAllById(info.getAdditionalServices()));
		acc.setAdditionalServices(serviceslocal);
		accomodationRepository.save(acc);

		List<Term> termsLocal = new ArrayList<Term>();
		for (TermInfo termInfo : termsInfo) {
			// term soap
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
			termSoap.setVisited(false);
			//
			Term termlocal = new Term();
			termlocal.setStartDate(termInfo.getStartDate());
			termlocal.setEndDate(termInfo.getEndDate());
			termlocal.setPrice(termInfo.getPrice());
			termlocal.setAccomodation(acc);
			termlocal.setReserved(false);
			termlocal.setVisited(false);
			Long id = accWebService.creatingTerm(termSoap, databaseId);
			termlocal.setDatabaseId(id);
			termRepository.save(termlocal);
			termsLocal.add(termlocal);
		}
		acc.setTerms(termsLocal);
		accomodationRepository.save(acc);

		// lokalno
		return acc;
	}

	@PostMapping("{id}")
	public ResponseEntity<?> uploadAccomodationImages(@PathVariable Long id,
			@ModelAttribute @Valid ImagesInfo imagesInfo) throws Exception {
		List<MultipartFile> images = imagesInfo.getImage();
		Accomodation accomodation = accomodationRepository.getOne(id);

		if (accomodation == null) {
			return ResponseEntity.notFound().build();
		}

		UploadModelXsd uploadModelXsd = new UploadModelXsd();
		List<DataHandler> dataHandlerImages = new ArrayList<>();

		for (MultipartFile image : images) {
			dataHandlerImages
					.add(new DataHandler(new InputStreamDataSource(image.getInputStream(), image.getContentType())));
		}

		uploadModelXsd.setImages(dataHandlerImages);
		uploadModelXsd.setId(accomodation.getDatabaseId());

		accWebService.uploadMultiple(uploadModelXsd);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Accomodation> getAllAccomodations() {
		return accomodationRepository.findAll();
	}

	@GetMapping("/{id}")
	public Accomodation getAccomodationById(@PathVariable("id") Long id) {
		return accomodationRepository.getOne(id);
	}

	@GetMapping("/{id}/terms")
	public List<Term> getTermsOfAccomodation(@PathVariable("id") Long id) {
		Accomodation acc = accomodationRepository.getOne(id);
		List<Term> terms = new ArrayList<>();
		for (Term term : acc.getTerms()) {
			terms.add(term);
		}
		return terms;
	}

	@PutMapping("/{id}")
	public Accomodation modifyAccomodation(@RequestBody AccomodationInfo info, @PathVariable("id") Long id)
			throws DatatypeConfigurationException {

		Accomodation acc = accomodationRepository.getOne(id);
		acc.setName(info.getName());
		acc.setCountry(info.getCountry());
		acc.setCity(info.getCity());
		acc.setAddress(info.getAddress());
		acc.setAccomodationType(accTypeRepo.getOne(info.getAccomodationType()));
		acc.setCategory(categoryRepository.getOne(info.getCategory()));
		acc.setDescription(info.getDescription());
		acc.setCapacity(info.getCapacity());
		
		Set<AdditionalService> services = new HashSet<AdditionalService>(
				addServiceRepository.findAllById(info.getAdditionalServices()));
		acc.getAdditionalServices().clear();
		acc.setAdditionalServices(services);
		acc = accomodationRepository.save(acc);

		AccomodationSoap accSoap = new AccomodationSoap();
		accSoap.setName(info.getName());
		accSoap.setCountry(info.getCountry());
		accSoap.setCity(info.getCity());
		accSoap.setAddress(info.getAddress());
		accSoap.setAccomodationType(accTypeRepo.getOne(info.getAccomodationType()).getDatabaseId());
		accSoap.setCategory(categoryRepository.getOne(info.getCategory()).getDatabaseId());
		accSoap.setDescription(info.getDescription());
		accSoap.setCapacity(info.getCapacity());
		accSoap.setId(acc.getDatabaseId());
		//dodatne usluge
		List<Long> asids = new ArrayList<>();
		for(Long asid : info.getAdditionalServices()) {
			asids.add(addServiceRepository.getOne(asid).getDatabaseId());
		}
		accSoap.setAdditionalServices(asids);
		List<TermSoap> termsSoap = new ArrayList<>();
		GregorianCalendar ca = new GregorianCalendar();
		TermSoap termS = new TermSoap();
		ca.setTime(new Date());
		termS.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(ca));
		ca.setTime(new Date());
		termS.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(ca));
		termsSoap.add(termS);
		accSoap.setTerms(termsSoap);
		accWebService.modifyAccomodation(accSoap);

		for (TermInfo terminfo : info.getTerms()) {
			if (terminfo.getId() != null) {
				Term term = termRepository.getOne(terminfo.getId());
				term.setStartDate(terminfo.getStartDate());
				term.setEndDate(terminfo.getEndDate());
				term.setPrice(terminfo.getPrice());
				term.setReserved(terminfo.isReserved());
				termRepository.save(term);

				// pozovi soap servis za modifikaciju
				GregorianCalendar c = new GregorianCalendar();
				TermSoap termSoap = new TermSoap();
				c.setTime(terminfo.getStartDate());
				termSoap.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
				c.setTime(terminfo.getEndDate());
				termSoap.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
				termSoap.setPrice(terminfo.getPrice());
				termSoap.setReserved(terminfo.isReserved());
				termSoap.setVisited(terminfo.isVisited());
				termSoap.setAccomodationId(acc.getDatabaseId());
				termSoap.setId(termRepository.getOne(terminfo.getId()).getDatabaseId());
				accWebService.modifyTerm(termSoap);
			} else {
				Term term = new Term();
				term.setStartDate(terminfo.getStartDate());
				term.setEndDate(terminfo.getEndDate());
				term.setPrice(terminfo.getPrice());
				term.setReserved(terminfo.isReserved());
				term.setAccomodation(acc);
				term = termRepository.save(term);

				// pozovi soap servis za kreiranje novog termina
				GregorianCalendar c = new GregorianCalendar();
				TermSoap termSoap = new TermSoap();
				c.setTime(terminfo.getStartDate());
				termSoap.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
				c.setTime(terminfo.getEndDate());
				termSoap.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
				termSoap.setPrice(terminfo.getPrice());
				termSoap.setReserved(terminfo.isReserved());
				termSoap.setVisited(terminfo.isVisited());
				termSoap.setAccomodationId(acc.getDatabaseId());
				Long dbid = accWebService.creatingTerm(termSoap, acc.getDatabaseId());
				term.setDatabaseId(dbid);
				termRepository.save(term);
			}
		}

		return acc;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeAccomodation(@PathVariable("id") Long id) {

		Accomodation acc = accomodationRepository.getOne(id);

		accWebService.deleteAccomodation(acc.getDatabaseId());
		accomodationRepository.deleteById(id);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@GetMapping("/{id}/{visited}")
	public ResponseEntity<String> setVisitedValue(@PathVariable("visited") boolean visited,
			@PathVariable("id") Long id) {

		Term term = termRepository.getOne(id);

		term.setVisited(visited);

		termRepository.save(term);

		accWebService.setVisitedValue(visited, term.getDatabaseId());

		return new ResponseEntity<>("Visited changed", HttpStatus.OK);
	}

	@GetMapping("/visited")
	public List<Term> getTerms() {
		return termRepository.findAll();
	}

	@GetMapping("/messages/{id}")
	public List<Message> getMessages(@PathVariable("id") Long id) {
		return messageRepository.findByTermId(id);
	}

	@PostMapping("/messages")
	public Message sendMessage(@RequestBody MessageInfo msgInfo) {
		MessageSoap msgSoap = new MessageSoap();
		msgSoap.setMessage(msgInfo.getMessage());
		msgSoap.setTermId(termRepository.getOne(msgInfo.getTermId()).getDatabaseId());

		Long dbid = accWebService.sendMessage(msgSoap);

		Message msg = new Message();
		msg.setDatabaseId(dbid);
		msg.setMessage(msgInfo.getMessage());
		msg.setTerm(termRepository.getOne(msgInfo.getTermId()));
		messageRepository.save(msg);

		return msg;
	}
	
	@GetMapping("/terms/{id}/reserved/{reserved}")
	public ResponseEntity<String> setReservedValue(@PathVariable("id") Long id,@PathVariable("reserved") boolean reserved){
		Term term = termRepository.getOne(id);
		//sync
		TermSoap termSoap = accWebService.getTerm(term.getDatabaseId());
		term.setStartDate(termSoap.getStartDate().toGregorianCalendar().getTime());
		term.setEndDate(termSoap.getEndDate().toGregorianCalendar().getTime());
		term.setReserved(termSoap.isReserved());
		term.setPrice(termSoap.getPrice());
		term.setDatabaseId(termSoap.getId());
		if(termSoap.getUserId() != null) {
			term.setUser(userRepository.findByDatabaseId(termSoap.getUserId()));
		}
		term = termRepository.save(term);
		//sync
		
		if(term.getUser() == null) {
			String result =accWebService.setReservedValue(term.getDatabaseId(), reserved);
			if(result != null) {
				term.setReserved(reserved);
				termRepository.save(term);
				return new ResponseEntity<>("Reservation successful",HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/{id}/comments")
	public List<CommentInfo> getCommentsForAccomodation(@PathVariable("id") Long id){
		Accomodation acc = accomodationRepository.getOne(id);
		List<AgentCommentSoap> agentComments = accWebService.getCommentsForAgent();
		List<CommentInfo> accomodationComments = new ArrayList<>();
		for(AgentCommentSoap comment : agentComments) {
			if(comment.getAccomodationId() == acc.getDatabaseId()) {
				CommentInfo cominfo = new CommentInfo();
				cominfo.setAccomodation(acc.getName());
				cominfo.setComment(comment.getComment());
				cominfo.setRating(comment.getRating());
				cominfo.setUsername(userRepository.findByDatabaseId(comment.getUserId()).getEmail());
				accomodationComments.add(cominfo);
			}
		}
		return accomodationComments;
	}
	
	@GetMapping("/sync")
	public void sync() {
		syncData.clean();
		syncData.init();	
		}
	
	@GetMapping("/terms/{termId}")
	public Term getTerm(@PathVariable("termId") Long termId) {
		return termRepository.getOne(termId);
		
	}

}
