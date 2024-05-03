package com.example.springbootbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public String addCourse() {
        Course course = new Course();
        course.setName(course.getName());
        course.setDescription(course.getDescription());;
        courseRepository.save(course);
        return "Added a new course!";
    }

    @GetMapping("/list")
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Course findCourseById(@PathVariable Integer id) {
        return courseRepository.findCourseById(id);
    }
}
