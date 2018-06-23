package agentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agentapp.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
<<<<<<< HEAD
	Category findByDatabaseId(Long id);
=======

	Category findByDatabaseId(Long id);
	
>>>>>>> branch 'master' of https://github.com/borishadzic/XWS-Project.git
}
