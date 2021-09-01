package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

// business service - typically SINGLETON !!! (ONLY one instance)

@Service //Stereotypical business service
public class TopicService {
	
	//  static list, change to mutable list to POST(create) new topic via ArrayList<>()...
	private List<Topic> topics = new ArrayList<>(Arrays.asList( // creates List in-line
			new Topic("spring", "Spring Framework", "SF description"),
			new Topic("java", "Core Java", "CJ description"),
			new Topic("javascript", "JavaScript", "JS description")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		//  lambda expression filter
		//  for each id, compare the id(parameter), find the first instance, returns it
		//  returns one topic object - in a JSON format
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		Topic t;
		int s = topics.size();
		for(int i= 0; i< s; i++) {
			t= topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}
	}

	
	public void deleteTopic(String id) {
		//  removes all topics in the list where the predicate is true
		//  for each item in topics,  .removeIf(predicate) is true
		topics.removeIf(t -> t.getId().equals(id));
	}


}