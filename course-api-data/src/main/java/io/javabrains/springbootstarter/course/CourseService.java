package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// typically SINGLETON !!! (ONLY one instance)

@Service //Stereotypical business service
public class CourseService {
	
	// dependency injection into instance
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		//  SEE java 8 Lambda basics from javabrains.io !!!
		//  iterating over the results from findAll and populating the topic list
		courseRepository.findByTopicId(topicId)
			.forEach(courses::add);
		
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course); 
	}
	
	//Spring framework will see the http request and polymophicaly return the right save method.
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}