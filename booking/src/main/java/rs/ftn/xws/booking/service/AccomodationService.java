package rs.ftn.xws.booking.service;

import java.util.List;

import rs.ftn.xws.booking.domain.Accomodation;

public interface AccomodationService {
	
	Accomodation addAccomodation(Accomodation accomodation);
	
	Accomodation modifyAccomodation(Accomodation accomodation);
	
	Accomodation removeAccomodation(Long accomodationId);
	
	List<Accomodation> getAll();
	
}
