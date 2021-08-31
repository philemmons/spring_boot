package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

// business service - typically a SINGLETON !!! (ONLY one copy)

@Service //sterotypical business service
public class TopicService {
	
	//  static list
	List<Topic> topics = Arrays.asList( // creates List inline
			new Topic("spring", "Spring Framework", "SF description"),
			new Topic("java", "Core Java", "CJ description"),
			new Topic("javascript", "JavaScript", "JS description")
			);
	
	public List<Topic> getAllTopics(){
		return topics;
	}
}