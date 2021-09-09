package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	//  Spring JPA Framework define methods in the Course Repo
	//  look at the method name and figure out the configuration needed
	
	//  provide a hint to Spring JPA  - create an extra filter
	//  there a specific structure for the CUSTOM method Spring needs
	//  find By Name 
	//  Declare findByProperty name format and Spring Data JPA will implement the method for you!
	//  *** be sure it is in camel case ***
	//  Property = Topic(class)Id(attribute)
	
	public List<Course> findByTopicId(String topicId);
	
	// it will match the rows in your table by the property declared in findBy Property format
	//  eg public List<Course> findByDescription(String foo);
	
}
//	no matter what the entity is, there are some standard operators - CRUD
//  Spring framework has these built-in features.
//  Also, Spring JPA has a built-in class
//  what we need is an interface.... which uses the implementation of the object
//  extending  CrudRepository
//  it need a couple generic types< T, id >