package io.javabrains.springbootstarter.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic("spring", "Spring Framework", "Spring Framework Decription"), new
	 * Topic("java", "Core Java", "Core Java Decription"), new Topic("js",
	 * "JavaScript Framework", "JavaScript Framework Decription") ));
	 */
	
	private Map<String, Topic> topicMap = new HashMap<>();
	
	public List<Topic> getAllTopics() {
//		return topics;
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
//		topics.add(topic);
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		/*
		 * for(int i = 0; i < topics.size(); i++) if(topics.get(i).getId().equals(id)) {
		 * topics.set(i, topic); return; }
		 */
		topicRepository.save(topic);	
		
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
//		for(int i = 0; i < topics.size(); i++)
//			if(topics.get(i).getId().equals(id)) {
//				topics.remove(i);
//				return;
//			}
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
		
	}

}
