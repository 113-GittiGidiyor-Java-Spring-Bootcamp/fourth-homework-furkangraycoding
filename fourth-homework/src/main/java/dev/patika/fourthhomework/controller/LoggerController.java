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
public class LoggerController {

    CourseService courseService;

    @Autowired
    public LoggerController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/loggers")
    public ResponseEntity<List<Course>> findAll(){

        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }


}
