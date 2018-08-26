package com.courses.coursesapidata.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	@Id
	private int id;
	private String courseName;
	private String courseDescription;
	@ManyToOne
	private Topic topic;
	
	public Course() {
		id=0;
		courseName=null;
		courseDescription=null;
		this.topic=null;
		
	}

	public Course(int id, String courseName, String courseDescription,int topicId) {
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.topic=new Topic(topicId,"","");
	}	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	
	

}
