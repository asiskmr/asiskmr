package com.yashtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yashtech.model.Course;
import com.yashtech.model.Topic;
import com.yashtech.service.CourseService;
import com.yashtech.service.TopicService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseServcie;
	
	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCoruses(@PathVariable("topicId") String topicId) {

		return courseServcie.getAllCourses(topicId);
	}
	
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
		return courseServcie.getCourse(id);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@PathVariable("topicId") String topicId, @RequestBody Course course) {		
		course.setTopic(new Topic(topicId, "", ""));
		courseServcie.addCourse(course);
	}
	
	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable("id") String id,@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseServcie.updateCourse(course);
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable("id") String id) {
		 courseServcie.deleteCourse(id);
	}
	
	
}
