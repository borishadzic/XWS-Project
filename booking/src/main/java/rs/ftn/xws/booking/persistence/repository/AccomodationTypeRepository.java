package rs.ftn.xws.booking.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.xws.booking.persistence.domain.AccomodationType;

@Repository
public interface AccomodationTypeRepository extends JpaRepository<AccomodationType,Long>{

	boolean existsByType(String type);
	List<AccomodationType> findByType(String type);
	
}
