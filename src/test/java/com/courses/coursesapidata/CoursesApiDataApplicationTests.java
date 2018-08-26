package com.courses.coursesapidata;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.courses.coursesapidata.controller.CourseAPIController;
import com.courses.coursesapidata.data.Course;
import com.courses.coursesapidata.data.Topic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoursesApiDataApplicationTests {
	@Autowired 
	private CourseAPIController controller;
	@Autowired
	private MockMvc mockMVC;
	private String BASE_URL="/";
	private MediaType mediaType=new MediaType(MediaType.APPLICATION_JSON.getType(),MediaType.APPLICATION_JSON.getSubtype(),Charset.forName("utf8"));
	private String jsonContentForTopic=
			"[    {        \"id\": 200,        \"courseName\": \"Spring\",        \"courseDescription\": \"Spring for Dummies\"    }]";
	
	

	@Test
	public void testCreateCourse() throws JsonProcessingException {
		String topicId="100";
		String url=BASE_URL+"topics/"+topicId+"/courses";
		Course courseRef=new Course();
		courseRef.setId(1000);
		courseRef.setCourseName("Java Web Development ");
		courseRef.setCourseDescription("Java Web Development ");
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(courseRef);
	    
		try {
			mockMVC.perform(
					post(url)
					.contentType(mediaType)
					.content(requestJson))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreateTopic() throws JsonProcessingException {
		String url=BASE_URL+"topics";
		Topic topicRef=new Topic();
		topicRef.setId(100);
		topicRef.setCourseName("Spring");
		topicRef.setCourseDescription("Spring for Dummies");
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(topicRef);
	    
		try {
			mockMVC.perform(
					post(url)
					.contentType(mediaType)
					.content(requestJson))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testgetTopics() throws JsonProcessingException {
		String url=BASE_URL+"topics";
		
	    
		try {
			mockMVC.perform(
					get(url)
					)
					.andExpect(status().isOk())
					.andExpect(content().json(jsonContentForTopic));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
