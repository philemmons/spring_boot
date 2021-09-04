package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

// This will tell Spring this class is an entity object for JPA which will be mapped
// AND create a table with three rows from the member vars
@Entity
public class Topic {
	
	
	//  assigns the primary key
	@Id
	private String id; 
	private String name;
	private String description;
	
	// right click, source, generate getters/setters
	
	// same here generate constructor with fields
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	//  java will do this by default
	public Topic() {
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
		
	



}
