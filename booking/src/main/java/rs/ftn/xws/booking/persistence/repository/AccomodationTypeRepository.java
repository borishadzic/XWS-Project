package rs.ftn.xws.booking.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.xws.booking.domain.AccomodationType;

@Repository
public interface AccomodationTypeRepository extends JpaRepository<AccomodationType,Long>{

}
