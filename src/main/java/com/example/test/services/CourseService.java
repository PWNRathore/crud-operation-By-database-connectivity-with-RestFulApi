package com.example.test.services;

import java.util.List;

import com.example.test.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	public Course getCourses(long courseId);

	public Course addCourse(Course course);

	//public Course deleteCourse(long courseId);

	public Course updateCourses(Course course);

	public void deleteCourse(long parseLong);
	
}
