package dev.patika.fourthhomework.controller;


import dev.patika.fourthhomework.dto.InstructorDTO;
import dev.patika.fourthhomework.dto.LoggerDTO;
import dev.patika.fourthhomework.mappers.LoggerMapper;
import dev.patika.fourthhomework.model.Instructor;
import dev.patika.fourthhomework.model.Logger;

import dev.patika.fourthhomework.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoggerController {

     LoggerService loggerService;


    @Autowired
    public LoggerController(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @PostMapping("/logs")
    public Logger saveLogs(@RequestBody LoggerDTO loggerDTO){
        return loggerService.save(loggerDTO);

    }

    @GetMapping("/logs")
    public ResponseEntity<List<Logger>> getAllLogs(){
        return new ResponseEntity<>(loggerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/logStatus/{status}")
    public ResponseEntity<List<Logger>> getAllByStatus(@PathVariable int status){
        return new ResponseEntity<>(loggerService.findAllByStatus(status),HttpStatus.OK);
    }

    @GetMapping("/logsDate/{date}")
    public ResponseEntity<List<Logger>> getLogsByDateAt(@PathVariable LocalDate date){
        return new ResponseEntity<>(loggerService.getByTimestampBetween(date),HttpStatus.OK);

    }



}
