package rs.ftn.xws.booking.service;

import java.util.List;

import rs.ftn.xws.booking.dto.MessageDto;
import rs.ftn.xws.booking.dto.RatingDto;
import rs.ftn.xws.booking.dto.ReservationDto;
import rs.ftn.xws.booking.exception.ReservationException;

public interface ReservationService {

	void reserve(Long termId, String userId) throws ReservationException;

	List<ReservationDto> getReservations();

	void cancelReservation(Long termId) throws ReservationException;

	List<MessageDto> getMessages(Long termId);
	
	boolean submitRating(Long termId, String userId, RatingDto ratingDto);

	MessageDto sendMessage(Long termId, String message, String userId) throws ReservationException;

}
