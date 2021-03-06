package agentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import agentapp.domain.Message;

public interface MessageRepository extends JpaRepository<Message,Long>{
	
	List<Message> findByTermId(Long id);
	
	Message findByDatabaseId(Long id);
	
}
