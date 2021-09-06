package dev.patika.fourthhomework.controller;


import dev.patika.fourthhomework.dto.InstructorDTO;
import dev.patika.fourthhomework.model.Instructor;
import dev.patika.fourthhomework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){

        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody InstructorDTO instructordto){

        return instructorService.save(instructordto);

    }
    @DeleteMapping("/instructors")
    public void deleteInstructor(@RequestBody InstructorDTO instructordto){

        instructorService.delete(instructordto);

    }

    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Deleted...";
    }

    @PutMapping("/instructors")
    public Instructor update(@RequestBody InstructorDTO instructordto){
        return instructorService.update(instructordto);
    }

    @PutMapping("/instructors/{id}")
    public String updateById(@RequestBody InstructorDTO instructordto,@PathVariable int id){
        instructorService.updateById(instructordto,id);
        return "Updated...";
    }

    @GetMapping("/getMaxSalary")
    public List<Instructor> getMaxSalary(){
        return instructorService.getMaxSalary();
    }

    @GetMapping("/getMinSalary")
    public List<Instructor> getMinSalary(){
        return instructorService.getMinSalary();
    }

    @DeleteMapping("/deleteInstuctorAllByName/{name}")
    public void deleteAllByName(@PathVariable String name){
        instructorService.deleteAllByName(name);
    }


    @GetMapping("/findInstructorAllByName/{name}")
    public ResponseEntity<List<Instructor>> findAllByName(@PathVariable String name){

        return new ResponseEntity<>(instructorService.findAllByName(name), HttpStatus.OK);
    }
}
