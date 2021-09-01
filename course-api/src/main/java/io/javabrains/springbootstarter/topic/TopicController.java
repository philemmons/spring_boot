package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	//  instance of singleton and inject it to this class.
	@Autowired // declare the dependency
	private TopicService topicService;
	
	//  remember to MAP the request and response
	//  going to return a LIST of objects
	//  the return type is going to be converted to JSON automatically!
	@RequestMapping("/topics") //  http request
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();//  http response
	}
	
	//  Parenthesis create a variable token for Spring
	@RequestMapping("/topics/{id}")
	
	//  whatever the path variable at 'foo', pass String id into it. 
	//  this is not recommended
	//  @RequestMapping("/topics/{foo}")
	//  public Topic getTopic(@PathVariable("foo") String id) {
	
	//  path variable maps the id from the request, to the method parameter
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//  specify the method, we don't want to use the GET method
	//  add the value property
	//  map this method to any request that's a POST on slash topics.
	//  get the post BODY, convert it into topic instance
	//  we need to edit the POST body!
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	//  Add @RequestBody with the Spring framework web bind annotation
	//  Your request payload is going to contain a JSON representation of this topic instance
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	//  change the POST method to PUT, add the {id} and PathVariable
	//  create updateTopic method
	//  same key:value on Postman - Content-Type:application/json
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}