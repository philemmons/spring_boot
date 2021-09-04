package io.javabrains.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;


// This will tell Spring this class is an entity object for JPA which will be mapped
// AND create a table with three rows from the member vars
@Entity
public class Course {
	
	//  assigns the primary key
	@Id
	private String id; 
	private String name;
	private String description;
	
	private Topic topic;
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.setTopic(new Topic(topicId, "", ""));
	}
	
	public Course() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}