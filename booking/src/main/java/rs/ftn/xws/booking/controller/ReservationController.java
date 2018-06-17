package rs.ftn.xws.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.xws.booking.dto.ReservationDto;
import rs.ftn.xws.booking.security.UserPrincipal;
import rs.ftn.xws.booking.service.ReservationService;

@RestController
@RequestMapping("api/reservations")
@PreAuthorize("isAuthenticated()")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@GetMapping
	public List<ReservationDto> get() {
		return reservationService.getReservations();
	}

	@PutMapping("{id}")
	public void put(@PathVariable Long id, Authentication authentication) {
		UserPrincipal currentUserPrincipal = (UserPrincipal) authentication.getPrincipal();	
		reservationService.reserve(id, currentUserPrincipal.getId());
	}

}
