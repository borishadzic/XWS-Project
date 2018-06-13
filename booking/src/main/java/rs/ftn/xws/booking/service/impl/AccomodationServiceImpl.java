package rs.ftn.xws.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.xws.booking.persistence.domain.Accomodation;
import rs.ftn.xws.booking.persistence.repository.AccomodationRepository;
import rs.ftn.xws.booking.service.AccomodationService;

@Service
public class AccomodationServiceImpl implements AccomodationService{
	
	@Autowired
	private AccomodationRepository accRepository;

	@Override
	public Accomodation addAccomodation(Accomodation accomodation) {
		return accRepository.save(accomodation);
	}

	@Override
	public Accomodation modifyAccomodation(Accomodation accomodation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accomodation removeAccomodation(Long accomodationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Accomodation> getAll() {
		return accRepository.findAll();
	}

}
