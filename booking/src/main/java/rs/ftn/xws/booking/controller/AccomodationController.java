package rs.ftn.xws.booking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.xws.booking.dto.Order;
import rs.ftn.xws.booking.dto.Sort;
import rs.ftn.xws.booking.dto.TermDto;
import rs.ftn.xws.booking.service.AccomodationService;

@RestController
@RequestMapping("api/accomodations")
public class AccomodationController {

	private static final String PATTERN = "yyyy-MM-dd";

	private AccomodationService accomodationService;
	
	public AccomodationController(AccomodationService accomodationService) {
		this.accomodationService = accomodationService;
	}
	
	@GetMapping("basic")
	public List<TermDto> get(@RequestParam String city,
					@RequestParam String country,
					@RequestParam float bprice,
					@RequestParam float tprice,
					@RequestParam @DateTimeFormat(pattern = PATTERN)  Date startDate,
					@RequestParam @DateTimeFormat(pattern = PATTERN)  Date endDate,
					@RequestParam(required = false, defaultValue = "PRICE") Sort sortBy,
					@RequestParam(required = false, defaultValue = "ASC") Order orderBy) {
		return accomodationService.searchBy(city, country, bprice, tprice, startDate, endDate, sortBy, orderBy);
	}
	
	@GetMapping("advanced")
	public List<TermDto> get(@RequestParam String city,
					@RequestParam String country,
					@RequestParam float bprice,
					@RequestParam float tprice,
					@RequestParam @DateTimeFormat(pattern = PATTERN)  Date startDate,
					@RequestParam @DateTimeFormat(pattern = PATTERN)  Date endDate,
					@RequestParam List<Long> types,
					@RequestParam List<Long> services,
					@RequestParam(required = false, defaultValue = "PRICE") Sort sortBy,
					@RequestParam(required = false, defaultValue = "ASC") Order orderBy) {		
		return accomodationService.searchBy(city, country, bprice, tprice, startDate, endDate, types, services, sortBy, orderBy);
	}
	
}
