package com.example.springbootbootapp;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    Course findCourseById(Integer id);
}