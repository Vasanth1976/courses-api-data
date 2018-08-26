package com.courses.coursesapidata.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.coursesapidata.data.Course;
import com.courses.coursesapidata.data.CourseRepository;
import com.courses.coursesapidata.data.Topic;
import com.courses.coursesapidata.data.TopicRepository;
@Service
public class CourseAPIService {
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Topic> getTopics() {
		List<Topic> topics =new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	public Topic getTopic(int id) {
		return topicRepository.findOne(id);
	}
	
	public void createTopic(Topic topic) {
		topicRepository.save(topic);
	}
	public void updateTopic(Topic topic,int id) {
		topicRepository.save(topic)	;
	}
	
	public void deleteTopic(int id) {
		topicRepository.delete(id);
	}
	
	public List<Course> getCourses(Integer topicId) {
		List<Course> courses =new ArrayList<>();		
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	public Course getCourse(int id) {
		return courseRepository.findOne(id);
	}
	
	public void createCourse(Course course) {
		courseRepository.save(course);
	}
	public void updateCourse(Course course,int id) {
		courseRepository.save(course)	;
	}
	
	public void deleteCourse(int id) {
		topicRepository.delete(id);
	}
	

}
