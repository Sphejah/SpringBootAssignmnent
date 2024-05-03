// Controller.java
package com.example.springbootbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public String addCourse(@RequestParam String name, @RequestParam String description) {
        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        String category = getCategory(name, description);
        course.setCategory(category);
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

    @PutMapping("/update/{id}")
    public String updateCourse(@PathVariable Integer id, @RequestParam String name, @RequestParam String description) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setName(name);
            course.setDescription(description);
            String category = getCategory(name, description);
            course.setCategory(category);
            courseRepository.save(course);
            return "Updated course with ID: " + id;
        }
        return "Course with ID " + id + " not found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.delete(course);
            return "Deleted course with ID: " + id;
        }
        return "Course with ID " + id + " not found";
    }

    private String getCategory(String name, String description) {
        if (name.toLowerCase().contains("foundation") || description.toLowerCase().contains("foundation")) {
            return "Foundation";
        } else if (name.toLowerCase().contains("undergraduate") || description.toLowerCase().contains("undergraduate")) {
            return "Undergraduate";
        } else if (name.toLowerCase().contains("honours") || description.toLowerCase().contains("honours")) {
            return "Honours";
        } else {
            return "Unknown";
        }
    }
}
