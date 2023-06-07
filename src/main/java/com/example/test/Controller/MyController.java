package com.example.test.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.entities.Course;
import com.example.test.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseservice;
	
	//return String
	
	@GetMapping("/home")
	public String home()
	{
		return "home";							
	}
	
	//get the courses
	
	@GetMapping("/courses")
	public List<Course>getCourses()
	{
		return this.courseservice.getCourses();
	}
	
	//get Courses by Id
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseservice.getCourses(Long.parseLong(courseId));
	}
	
	// add Courses 
	
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course course)
	{
		return this.courseservice.addCourse(course);
	}
	
	//update Courses
	
	@PutMapping("/courses/{courseId}")
	public Course updatecourses(@RequestBody Course course)
	{
		return this.courseservice.updateCourses(course);
	}
	
	//Delete Courses
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus>deleteCourse(@PathVariable String courseId) 
	{
	try
		{
		this.courseservice.deleteCourse(Long.parseLong(courseId));
		    	return new ResponseEntity<>(HttpStatus.OK);
		}
	catch (Exception e)
	{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}


