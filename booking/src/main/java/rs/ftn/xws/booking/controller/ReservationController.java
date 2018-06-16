package rs.ftn.xws.booking.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.xws.booking.security.UserPrincipal;

@RestController
@RequestMapping("api/reservations")
@PreAuthorize("isAuthenticated()")
public class ReservationController {

	@GetMapping
	public void get(Authentication authentication) {
		UserPrincipal details = (UserPrincipal) authentication.getPrincipal();
		System.out.println(details.getId());
	}
	
	@PutMapping("{id}")
	public void put(@PathVariable Long id, Authentication authentication) {
		UserPrincipal details = (UserPrincipal) authentication.getPrincipal();
		System.out.println(details.getId());
		System.out.println(id);
	}
	
}
