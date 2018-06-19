package agentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agentapp.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByDatabaseId(String id);
	
}
