// Controller.java
package com.example.springbootbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public String addCourse(@RequestParam String name, @RequestParam String description) {
        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        courseRepository.save(course);
        return "Added a new course!";
    }

    @GetMapping("/list")
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Course findCourseById(@PathVariable Integer id) {
        return courseRepository.findById(id).orElse(null);
    }
}
