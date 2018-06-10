package rs.ftn.xws.booking.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.xws.booking.domain.Term;

@Repository
public interface TermRepository extends JpaRepository<Term,Long>{

}
