package dev.patika.fourthhomework.controller;


import dev.patika.fourthhomework.dto.CourseDTO;
import dev.patika.fourthhomework.model.Course;
import dev.patika.fourthhomework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll(){

        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){

        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody CourseDTO courseDTO){

        return courseService.save(courseDTO);

    }
    @DeleteMapping("/courses")
    public void deleteCourse(@RequestBody Course course){

        courseService.delete(course);

    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
        return "Deleted...";
    }

    @PutMapping("/courses")
    public Course update(@RequestBody Course course){
        return courseService.update(course);
    }

    @PutMapping("/courses/{id}")
    public String updateById(@RequestBody Course course,@PathVariable int id){
        courseService.updateById(course,id);
        return "Updated...";
    }

    @DeleteMapping("/deleteCourseAllByName/{name}")
    public void deleteByCourseName(@PathVariable String name){
        courseService.deleteByCourseName(name);
    }

    @GetMapping("/findAllByCourseName/{name}")
    public ResponseEntity<List<Course>> findAllByCourseName(@PathVariable String name){

        return new ResponseEntity<>(courseService.findAllByCourseName(name), HttpStatus.OK);
    }


}
