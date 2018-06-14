package rs.ftn.xws.booking.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.xws.booking.dto.AccomodationDto;
import rs.ftn.xws.booking.dto.Order;
import rs.ftn.xws.booking.dto.Sort;
import rs.ftn.xws.booking.dto.TermDto;
import rs.ftn.xws.booking.persistence.domain.Accomodation;
import rs.ftn.xws.booking.persistence.domain.AccomodationImage;
import rs.ftn.xws.booking.persistence.domain.AccomodationType;
import rs.ftn.xws.booking.persistence.domain.AdditionalService;
import rs.ftn.xws.booking.persistence.domain.Term;
import rs.ftn.xws.booking.persistence.repository.AccomodationRepository;
import rs.ftn.xws.booking.persistence.repository.AccomodationTypeRepository;
import rs.ftn.xws.booking.persistence.repository.AdditionalServiceRepository;
import rs.ftn.xws.booking.service.AccomodationService;

@Service
@Transactional
public class AccomodationServiceImpl implements AccomodationService {

	@Autowired
	private AccomodationRepository accomodationRepository;

	@Autowired
	private AccomodationTypeRepository accomodationTypeRepository;

	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;

	@Override
	public Accomodation addAccomodation(Accomodation accomodation) {
		return accomodationRepository.save(accomodation);
	}

	@Override
	public Accomodation modifyAccomodation(Accomodation accomodation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accomodation removeAccomodation(Long accomodationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Accomodation> getAll() {
		return accomodationRepository.findAll();
	}

	@Override
	public List<TermDto> searchBy(String city, String country, float bprice, float tprice, Date startDate,
			Date endDate, Sort sortBy, Order orderBy) {
		List<Accomodation> accomodations = accomodationRepository.findByCityAndCountryAllIgnoringCase(city, country);
		accomodations = filterByTerms(accomodations, startDate, endDate, bprice, tprice);
		
		List<TermDto> terms = convert(accomodations);
		
		return sortAndOrer(terms, sortBy, orderBy);
	}

	@Override
	public List<TermDto> searchBy(String city, String country, float bprice, float tprice, Date startDate,
			Date endDate, List<Long> types, List<Long> services, Sort sortBy, Order orderBy) {
		List<Accomodation> accomodations = accomodationRepository.findByCityAndCountryAllIgnoringCase(city, country);
		List<AccomodationType> accomodationTypes = accomodationTypeRepository.findAllById(types);
		List<AdditionalService> accomodationServices = additionalServiceRepository.findAllById(services);
		
		accomodations = filterByTypes(accomodations, accomodationTypes);
		accomodations = filterByServices(accomodations, accomodationServices);
		accomodations = filterByTerms(accomodations, startDate, endDate, bprice, tprice);
		
		return convert(accomodations);
	}

	private List<Accomodation> filterByTypes(List<Accomodation> accomodations, List<AccomodationType> types) {
		return accomodations.stream()
			.filter(a -> types.contains(a.getAccomodationType()))
			.collect(Collectors.toList());
	}

	private List<Accomodation> filterByServices(List<Accomodation> accomodations, List<AdditionalService> services) {
		return accomodations.stream()
				.filter(a -> a.getAdditionalServices().containsAll(services))
				.collect(Collectors.toList());
	}

	private List<Accomodation> filterByTerms(List<Accomodation> accomodations, Date startDate, Date endDate,
			float bPrice, float tPrice) {
		accomodations.forEach(a -> {
			List<Term> terms = a.getTerms().stream()
					.filter(t -> {
						boolean dateComparison = t.getStartDate().after(startDate) && t.getEndDate().before(endDate);
						if (dateComparison)
							return !(t.getPrice() >= bPrice && t.getPrice() <= tPrice);
						return !dateComparison;
					}).collect(Collectors.toList());

			a.getTerms().removeAll(terms);
		});

		return accomodations.stream()
				.filter(a -> a.getTerms().size() > 0)
				.collect(Collectors.toList());
	}

	public List<TermDto> convert(List<Accomodation> accomodations) {
		List<TermDto> termDtos = new ArrayList<>();

		for (Accomodation a : accomodations) {
			String type = a.getAccomodationType().getType();

			List<String> images = a.getImages().stream()
					.map(AccomodationImage::getUrl)
					.collect(Collectors.toList());

			List<String> services = a.getAdditionalServices().stream()
					.map(AdditionalService::getName)
					.collect(Collectors.toList());

			AccomodationDto accDto = new AccomodationDto(a.getId(), a.getName(), a.getCountry(), a.getCity(),
					a.getAddress(), type, services, images);
			
			List<TermDto> terms = a.getTerms().stream()
					.map(t -> new TermDto(t.getId(), t.getStartDate(), t.getEndDate(), t.getPrice(), accDto))
					.collect(Collectors.toList());
			
			termDtos.addAll(terms);
		}

		return termDtos;
	}
	
	public List<TermDto> sortAndOrer(List<TermDto> terms, Sort sortBy, Order orderBy) {
		Comparator<? super TermDto> comparator = null;
		
		if (sortBy == Sort.PRICE) {
			comparator = Comparator.comparing(t -> ((TermDto)t).getPrice());
		} else if (sortBy == Sort.CATEGORY) {
			// Ne valja trenutno
			comparator = Comparator.comparing(t -> ((TermDto)t).getPrice());
		} else {
			// Isto ne valja trenutno
			comparator = Comparator.comparing(t -> ((TermDto)t).getPrice());
		}
		
		if (orderBy == Order.DESC) {
			comparator = comparator.reversed();
		}
		
		return terms.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
	}

}
