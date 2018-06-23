package rs.ftn.xws.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.xws.booking.dto.BonusDto;
import rs.ftn.xws.booking.dto.FilterDto;
import rs.ftn.xws.booking.persistence.domain.AccomodationType;
import rs.ftn.xws.booking.persistence.domain.AdditionalService;
import rs.ftn.xws.booking.persistence.domain.Category;
import rs.ftn.xws.booking.service.SearchFilterService;

@RestController
@RequestMapping("api/filter")
public class FilterController {

	@Autowired
	private SearchFilterService searchFilterService;
	
	@GetMapping
	public FilterDto get() {
		return searchFilterService.getSearchFilter();
	}
	
	@PostMapping("/types")
	@PreAuthorize("hasRole('ADMIN')")
	public AccomodationType postType(BonusDto type) {
		return searchFilterService.addType(type.getName());
	}
	
	@PostMapping("/categories")
	@PreAuthorize("hasRole('ADMIN')")
	public Category postCategory(BonusDto category) {
		return searchFilterService.addCategory(category.getName());
	}
	
	@PostMapping("/services")
	@PreAuthorize("hasRole('ADMIN')")
	public AdditionalService postService(BonusDto name) {
		return searchFilterService.addAdditionalService(name.getName());
	}
	
}
