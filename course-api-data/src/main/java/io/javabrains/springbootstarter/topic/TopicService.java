package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// business service - typically SINGLETON !!! (ONLY one instance)

@Service //Stereotypical business service
public class TopicService {
	
	// autowire time - dependency injection into instance
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		//  return topics;
		
		//  make a call to the topicRepository
		//  this is all we have to do connect to DB, run a query, get the rows, and convert it back
		//  convert this to a list
		List<Topic> topics = new ArrayList<>();
		
		//  lambda expression
		//  SEE java 8 Lambda basics from javabrains.io !!!
		//  iterating over the results from findAll and 
		//  populating the topic list
		topicRepository.findAll()
			.forEach(topics::add);
		
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//  lambda expression filter
		//  for each id, compare the id(parameter), find the first instance, returns it
		//  returns one topic object - in a JSON format
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	
		 return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		
		topicRepository.save(topic); 
	}
	
	//Spring framework will see the http request and polymophicaly return the right save method.
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	
	public void deleteTopic(String id) {
		//  removes all topics in the list where the predicate is true
		//  for each item in topics,  .removeIf(predicate) is true
		//topics.removeIf(t -> t.getId().equals(id));
		
		topicRepository.deleteById(id);
	}


}