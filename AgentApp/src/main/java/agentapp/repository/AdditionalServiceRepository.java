package agentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agentapp.domain.AdditionalService;


@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalService,Long>{
	
	AdditionalService findByDatabaseId(Long id);
	
<<<<<<< HEAD
	List<AdditionalService> findAllByDatabaseId(Iterable<Long> arg0);
	
=======
>>>>>>> branch 'master' of https://github.com/borishadzic/XWS-Project.git
}
