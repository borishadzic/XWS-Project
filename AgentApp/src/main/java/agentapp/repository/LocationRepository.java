package agentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agentapp.domain.Location;


@Repository
public interface LocationRepository extends JpaRepository<Location,Long>{

}
