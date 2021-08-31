package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	//  instance of singleton and inject it
	@Autowired
	private TopicService topicService;
	
	
	//  remember to MAP the request and response
	//  going to return a LIST of objects
	//  the return type is going to be converted to JSON automatically!
	@RequestMapping("/topics") //  http request
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();//  http response
	}

}