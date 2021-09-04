package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
	
	//  getAllTopics()
	//  getTopic(Sting id)
	//	updateTopic(Topic t)
	//	deleteTopic(String id)
	
	//  no matter what the entity is, there are some standard operators
	//  Spring framework has these built-in features.
	//  Also, Spring JPA has a built-in class
	
	// what we need is an interface.... which uses the implementation of the object
	// extend CrudRepository
	// it need a couple generic types< T, id >
	
}
