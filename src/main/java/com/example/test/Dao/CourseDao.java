package com.example.test.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.entities.Course;

public interface CourseDao extends JpaRepository< Course, Long> {

}
