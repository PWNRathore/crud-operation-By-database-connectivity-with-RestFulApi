package com.example.test.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.Dao.CourseDao;
import com.example.test.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired 
	private CourseDao courseDao;
	
	//List<Course> list;
	public CourseServiceImpl() {
		
		/*list = new ArrayList<>();
		list.add(new Course(145,"core java","this course is useful for java"));
		list.add(new Course(130,"phython","this course is useful for phython"));*/
	}
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourses(long courseId) {
      /* Course c=null;
       for (Course course : list) {
		if (course.getId()==courseId) {
			c=course;
			break;	
		}
	}*/
		return courseDao.getOne(courseId) ;
	}
	
	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		courseDao.save(course);
		
		return course;
	}
	
	@Override
	public Course updateCourses(Course course) {
	/*	for(Course c:list)
		{
			if(c.getId()==course.getId()) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
			}
		}*/
		courseDao.save(course);
		return course;
	}
	
	@Override
	public void deleteCourse(long parseLong) {
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}

}

	
	
	
	

	
