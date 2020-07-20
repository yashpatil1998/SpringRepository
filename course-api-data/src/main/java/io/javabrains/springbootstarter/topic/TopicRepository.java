package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface TopicRepository extends CrudRepository<Topic, String> {
	
	

}
