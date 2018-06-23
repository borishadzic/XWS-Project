package rs.ftn.xws.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.xws.booking.dto.FilterDto;
import rs.ftn.xws.booking.persistence.domain.AccomodationType;
import rs.ftn.xws.booking.persistence.domain.AdditionalService;
import rs.ftn.xws.booking.persistence.domain.Category;
import rs.ftn.xws.booking.persistence.repository.AccomodationTypeRepository;
import rs.ftn.xws.booking.persistence.repository.AdditionalServiceRepository;
import rs.ftn.xws.booking.persistence.repository.CategoryRepository;
import rs.ftn.xws.booking.service.SearchFilterService;

@Service
public class SearchFilterServiceImpl implements SearchFilterService {

	@Autowired
	private AccomodationTypeRepository accomodationTypeRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;

	
	
	@Override
	public AccomodationType addType(String type) {
		if (!accomodationTypeRepository.existsByType(type)) {
			return accomodationTypeRepository.save(new AccomodationType(type));
		}

		return null;
	}

	@Override
	public Category addCategory(String category) {
		if (!categoryRepository.existsByCategory(category)) {
			return categoryRepository.save(new Category(category));
		}

		return null;
	}

	@Override
	public AdditionalService addAdditionalService(String name) {
		if (additionalServiceRepository.findByName(name).isEmpty()) {
			return additionalServiceRepository.save(new AdditionalService(name));
		}

		return null;
	}
	
	@Override
	public FilterDto getSearchFilter() {
		List<AccomodationType> types = accomodationTypeRepository.findAll();
		List<Category> categories = categoryRepository.findAll();
		List<AdditionalService> services = additionalServiceRepository.findAll();
		
		return new FilterDto(types, categories, services);
	}

	@Override
	public AccomodationType modifyType(String oldType, String newType) {
		if(accomodationTypeRepository.findByType(oldType).isEmpty()) {
			return null;
		}
		
		AccomodationType type = accomodationTypeRepository.findByType(oldType).get(0);
		type.setType(newType);
		accomodationTypeRepository.save(type);
		return type;
	}

	@Override
	public Category modifyCategory(String oldCat, String newCat) {
		if(categoryRepository.findByCategory(oldCat).isEmpty()) {
			return null;
		}
		
		Category type = categoryRepository.findByCategory(oldCat).get(0);
		type.setCategory(newCat);
		categoryRepository.save(type);
		return type;
	}

	@Override
	public AdditionalService modifyService(String oldServ, String newServ) {
		if(additionalServiceRepository.findByName(oldServ).isEmpty()) {
			return null;
		}
		
		AdditionalService type = additionalServiceRepository.findByName(oldServ).get(0);
		type.setName(newServ);
		additionalServiceRepository.save(type);
		return type;
	}

}
