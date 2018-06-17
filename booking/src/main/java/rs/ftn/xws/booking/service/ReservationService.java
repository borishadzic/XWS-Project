package rs.ftn.xws.booking.service;

import java.util.List;

import rs.ftn.xws.booking.dto.ReservationDto;
import rs.ftn.xws.booking.exception.ReservationException;

public interface ReservationService {

	void reserve(Long termId, String userId) throws ReservationException;

	List<ReservationDto> getReservations();

}
