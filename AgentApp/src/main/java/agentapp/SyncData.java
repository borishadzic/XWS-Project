package agentapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agentapp.domain.Accomodation;
import agentapp.domain.AccomodationType;
import agentapp.domain.AdditionalService;
import agentapp.domain.Category;
import agentapp.domain.Message;
import agentapp.domain.Term;
import agentapp.domain.User;
import agentapp.repository.AccomodationRepository;
import agentapp.repository.AccomodationTypeRepository;
import agentapp.repository.AdditionalServiceRepository;
import agentapp.repository.CategoryRepository;
import agentapp.repository.MessageRepository;
import agentapp.repository.TermRepository;
import agentapp.repository.UserRepository;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationSoap;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationTypeSoap;
import rs.ftn.xws.booking.accomodationwebservice.AccomodationWebServiceSoap;
import rs.ftn.xws.booking.accomodationwebservice.AdditionalServiceSoap;
import rs.ftn.xws.booking.accomodationwebservice.CategorySoap;
import rs.ftn.xws.booking.accomodationwebservice.MessageSoap;
import rs.ftn.xws.booking.accomodationwebservice.TermSoap;
import rs.ftn.xws.booking.accomodationwebservice.UserSoap;

@Component
public class SyncData {
	
	@Autowired
	private AccomodationWebServiceSoap accWebService;
	
	@Autowired
	private AccomodationTypeRepository accTypeRepository;
	
	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private TermRepository termRepository;
	
	@Autowired
	private AccomodationRepository accRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	@PostConstruct
	@Transactional
	public void init() {
			
			System.out.println("########## SINHRONIZACIJAA #############");
	
			/*accTypeRepository.deleteAll();
			additionalServiceRepository.deleteAll();
			categoryRepository.deleteAll();
			messageRepository.deleteAll();
			userRepository.deleteAll();
			termRepository.deleteAll();*/
		
		
			List<AccomodationTypeSoap> typesSoap = accWebService.getAllAccomodationTypes();
			List<AdditionalServiceSoap> servicesSoap = accWebService.getAllAdditionalServices();
			List<CategorySoap> categoriesSoap = accWebService.getAllCategories();
			List<UserSoap> usersSoap  = accWebService.getAllUsers();
			List<MessageSoap> messagesSoap = accWebService.getMessagesForAgent();
			
			for(UserSoap userSoap : usersSoap) {
				User user = new User();
				user.setEmail(userSoap.getEmail());
				user.setDatabaseId(userSoap.getId());
				userRepository.save(user);
			}
			
			for(AccomodationTypeSoap typeSoap : typesSoap) {
				AccomodationType type = new AccomodationType();
				type.setType(typeSoap.getType());
				type.setDatabaseId(typeSoap.getId());
				accTypeRepository.save(type);
			}
			
			for(AdditionalServiceSoap serviceSoap : servicesSoap) {
				AdditionalService service = new AdditionalService();
				service.setName(serviceSoap.getName());
				service.setDatabaseId(serviceSoap.getId());
				additionalServiceRepository.save(service);
			}
			
			for(CategorySoap categorySoap : categoriesSoap) {
				Category category = new Category();
				category.setCategory(categorySoap.getCategory());
				category.setDatabaseId(categorySoap.getId());
				categoryRepository.save(category);
			}
			
			for(AccomodationSoap accSoap : accWebService.getAll()) {
				Accomodation acc = new Accomodation();
				acc.setName(accSoap.getName());
				acc.setCountry(accSoap.getCountry());
				acc.setCity(accSoap.getCity());
				acc.setAddress(accSoap.getAddress());
				acc.setDescription(accSoap.getDescription());
				acc.setDatabaseId(accSoap.getId());
				acc.setAccomodationType(accTypeRepository.findByDatabaseId(accSoap.getAccomodationType()));
				acc.setCategory(categoryRepository.findByDatabaseId(accSoap.getCategory()));
				acc.setCapacity(accSoap.getCapacity());
<<<<<<< HEAD
				//proba
				List<Long> asids = new ArrayList<>();
				for(Long asid : accSoap.getAdditionalServices()){
					asids.add(additionalServiceRepository.findByDatabaseId(asid).getId());
				}
				//proba
=======
				//dodatne usluge
				List<Long> asids = new ArrayList<>();
				for(Long asid : accSoap.getAdditionalServices()) {
					asids.add(additionalServiceRepository.findByDatabaseId(asid).getId());
				}
>>>>>>> branch 'master' of https://github.com/borishadzic/XWS-Project.git
				Set<AdditionalService> serviceslocal = new HashSet<AdditionalService>(additionalServiceRepository.findAllById(asids));
				acc.setAdditionalServices(serviceslocal);
				//acc.setTerms(new ArrayList<Term>());
				acc = accRepository.save(acc);
				for(TermSoap termSoap: accSoap.getTerms() ) {
					Term term = new Term();
					term.setStartDate(termSoap.getStartDate().toGregorianCalendar().getTime());
					term.setEndDate(termSoap.getEndDate().toGregorianCalendar().getTime());
					term.setPrice(termSoap.getPrice());
					term.setDatabaseId(termSoap.getId());
					term.setAccomodation(acc);
					term.setVisited(termSoap.isVisited());
					term.setReserved(termSoap.isReserved());
					term.setUser(userRepository.findByDatabaseId(termSoap.getUserId()));
//					acc.getTerms().add(term);
					termRepository.save(term);
					
				}
//				accRepository.save(acc);
				
			}
			
			for(MessageSoap msgSoap : messagesSoap) {
				Message msg = new Message();
				msg.setDatabaseId(msgSoap.getId());
				msg.setMessage(msgSoap.getMessage());
				msg.setTerm(termRepository.findByDatabaseId(msgSoap.getTermId()));
				msg.setUser(userRepository.findByDatabaseId(msgSoap.getUserId()));
				messageRepository.save(msg);
				
			}
		
	}
	
	@Transactional
<<<<<<< HEAD
	public void clean(){
		List<AccomodationType> temptype = new ArrayList<>();
		for(AccomodationType accType : accTypeRepository.findAll()){
			temptype.add(accType);
		}
		accTypeRepository.deleteAll(temptype);
		
		List<AdditionalService> tempservice = new ArrayList<>();
		for(AdditionalService accService : additionalServiceRepository.findAll()){
			tempservice.add(accService);
		}
		additionalServiceRepository.deleteAll(tempservice);
		
		List<Category> tempcat = new ArrayList<>();
		for(Category cat : categoryRepository.findAll()){
			tempcat.add(cat);
		}
		categoryRepository.deleteAll(tempcat);
		
		List<Message> tempmsg = new ArrayList<>();
		for(Message msg : messageRepository.findAll()){
			tempmsg.add(msg);
		}
		messageRepository.deleteAll(tempmsg);
		
		List<User> tempuser = new ArrayList<>();
		for(User user : userRepository.findAll()){
			tempuser.add(user);
		}
		userRepository.deleteAll(tempuser);
		
		List<Accomodation> tempacc = new ArrayList<>();
		for(Accomodation acc : accRepository.findAll()){
			tempacc.add(acc);
		}
		accRepository.deleteAll(tempacc);
=======
	public void clean() {
		messageRepository.deleteAll();
		additionalServiceRepository.deleteAll();
		termRepository.deleteAll();
		userRepository.deleteAll();
		accRepository.deleteAll();
		categoryRepository.deleteAll();
		accTypeRepository.deleteAll();
>>>>>>> branch 'master' of https://github.com/borishadzic/XWS-Project.git
	}
	
}
