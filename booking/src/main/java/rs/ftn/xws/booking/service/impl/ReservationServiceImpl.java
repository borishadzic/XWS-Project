package rs.ftn.xws.booking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.xws.booking.dto.ReservationDto;
import rs.ftn.xws.booking.exception.ReservationException;
import rs.ftn.xws.booking.persistence.domain.Term;
import rs.ftn.xws.booking.persistence.domain.User;
import rs.ftn.xws.booking.persistence.repository.TermRepository;
import rs.ftn.xws.booking.persistence.repository.UserRepository;
import rs.ftn.xws.booking.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private TermRepository termRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void reserve(Long termId, String userId) throws ReservationException {
		Term term = termRepository.findByIdAndReservedFalse(termId)
				.orElseThrow(() -> new ReservationException("Reservation not found or has already been reserverd"));

		User currentUser = userRepository.findCurrentUser();
		
		term.setUser(currentUser);
		term.setReserved(true);
		termRepository.save(term);
	}

	@Override
	public List<ReservationDto> getReservations() {
		return termRepository.findCurrentUserReservations().stream()
				.map(ReservationDto::new)
				.collect(Collectors.toList());
	}

}
