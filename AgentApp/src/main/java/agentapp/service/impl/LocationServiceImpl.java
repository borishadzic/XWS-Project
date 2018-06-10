package agentapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agentapp.domain.Location;
import agentapp.repository.LocationRepository;
import agentapp.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location addLocation(Location location) {
		return locationRepository.save(location);
	}

}
