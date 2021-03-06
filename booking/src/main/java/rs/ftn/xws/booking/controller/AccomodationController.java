package rs.ftn.xws.booking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.xws.booking.cloud.CloudFunctionsService;
import rs.ftn.xws.booking.cloud.model.Comment;
import rs.ftn.xws.booking.dto.Order;
import rs.ftn.xws.booking.dto.Sort;
import rs.ftn.xws.booking.dto.TermDto;
import rs.ftn.xws.booking.service.AccomodationService;

@RestController
@RequestMapping("api/accomodations")
public class AccomodationController {

	private AccomodationService accomodationService;
	private CloudFunctionsService cloudFunctionsService;
	
	public AccomodationController(AccomodationService accomodationService, CloudFunctionsService cloudFunctionsService) {
		this.accomodationService = accomodationService;
		this.cloudFunctionsService = cloudFunctionsService;
	}
	
	@GetMapping
	public List<TermDto> get() {
		return accomodationService.getTerms();
	}
	
	@GetMapping("search")
	public List<TermDto> get(@RequestParam String city,
					@RequestParam String country,
					@RequestParam int capacity,
					@RequestParam Date startDate,
					@RequestParam Date endDate,
					@RequestParam(required = false, defaultValue = "") List<Long> types,
					@RequestParam(required = false, defaultValue = "") List<Long> categories,
					@RequestParam(required = false, defaultValue = "") List<Long> services,
					@RequestParam(required = false, defaultValue = "PRICE") Sort sortBy,
					@RequestParam(required = false, defaultValue = "ASC") Order orderBy) {
		return accomodationService.searchBy(city, country, capacity, startDate, endDate, types, categories, services, sortBy, orderBy);
	}
	
	@GetMapping("{id}/comments")
	public List<Comment> get(@PathVariable Long id) {
		return cloudFunctionsService.getApprovedComments(id);
	}
	
}
