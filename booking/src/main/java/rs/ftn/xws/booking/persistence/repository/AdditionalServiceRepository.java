package rs.ftn.xws.booking.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.xws.booking.domain.AdditionalService;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalService,Long>{

}
