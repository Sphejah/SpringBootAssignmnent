package com.example.springbootbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@RestController
public class SpringBootBootAppApplication {


    public static void main(String[] args) {

        SpringApplication.run(SpringBootBootAppApplication.class, args);


    }

    @GetMapping("/Courses")
    public String getCourses(@RequestParam(value = "courseName", defaultValue = "This course doesn't exist") String name) {
        return foundationCourses(name) + "<br>" +
                undergraduateCourses(name) + "<br>" +
                honoursCourses(name);
    }

    @GetMapping("/foundationCourse")
    private String foundationCourses(@RequestParam(value = "courseName", defaultValue = " ") String name) {
        List<String> foundationCourses = new ArrayList<>();
        foundationCourses.add("Computer Literacy for Science (F)");
        foundationCourses.add("Advanced Computer Programming (F)");

        return String.format(String.valueOf(foundationCourses));

    }

    @GetMapping("/undergraduateCourse")

    private String undergraduateCourses(@RequestParam(value = "courseName", defaultValue = " ") String name) {

        List<String> undergraduateCourses = new ArrayList<>();
        undergraduateCourses.add("Advanced Programming");
        undergraduateCourses.add("Computer Architecture and Organisation");
        undergraduateCourses.add("Software Engineering");
        undergraduateCourses.add("Operating Systems");
        undergraduateCourses.add("Computer Networks");
        return String.format(String.valueOf(undergraduateCourses));

    }

    @GetMapping("/honoursCourse")
    private String honoursCourses(@RequestParam(value = "courseName", defaultValue = " ") String name) {
        List<String> honoursCourses = new ArrayList<>();
        honoursCourses.add("Advanced Java Programming");
        honoursCourses.add("Mini Project");
        honoursCourses.add("Intelligent Systems");
        honoursCourses.add("Distributed Web Computing");
        return String.format(String.valueOf(honoursCourses));

    }
}