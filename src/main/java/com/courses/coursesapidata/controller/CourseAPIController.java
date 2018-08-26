package com.courses.coursesapidata.controller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courses.coursesapidata.data.Course;
import com.courses.coursesapidata.data.Topic;
import com.courses.coursesapidata.service.CourseAPIService;

@RestController
public class CourseAPIController {
	@Autowired
	private CourseAPIService courseAPIService;
	
	@RequestMapping(value="/topics")
	public List<Topic> getTopics() {
		return courseAPIService.getTopics();
		
	}
	@RequestMapping(value="/topics/id/{id}")
	public Topic getTopic(@PathVariable("id") int id) {
		return courseAPIService.getTopic(id);
		
	}
	@RequestMapping(value="/topics",method=RequestMethod.POST)
	public void createTopic(@RequestBody Topic topic) {
		courseAPIService.createTopic(topic);
	}
	
	@RequestMapping(value="/topics/id/{id}",method=RequestMethod.PUT)
	public void updateTopic(@PathVariable("id") int id,@RequestBody Topic topic) {
		courseAPIService.updateTopic(topic,id);
	}
	@RequestMapping(value="/topics/id/{id}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable("id") int id) {
		courseAPIService.deleteTopic(id);
	}

	
	
	@RequestMapping(value="/topics/{id}/courses")
	public List<Course> getCourses(@PathVariable("id") int id) {
		return courseAPIService.getCourses(id);
		
	}
	@RequestMapping(value="/topics/{topicid}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") int courseId) {
		return courseAPIService.getCourse(courseId);
		
	}
	@RequestMapping(value="/topics/{topicid}/courses",method=RequestMethod.POST)
	public void createCourse(@RequestBody Course course,@PathVariable("topicid") int topicid) {
		course.setTopic(new Topic(topicid,"",""));
		courseAPIService.createCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicid}/courses/{id}",method=RequestMethod.PUT)
	public void updateCourse(@PathVariable("topicid") int topicid,@PathVariable("id") int id,@RequestBody Course course) {
		course.setTopic(new Topic(topicid,"",""));
		courseAPIService.updateCourse(course,id);
	}
	@RequestMapping(value="/topics/{topicid}/courses/{id}",method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") int id) {
		courseAPIService.deleteCourse(id);
	}
	

}
