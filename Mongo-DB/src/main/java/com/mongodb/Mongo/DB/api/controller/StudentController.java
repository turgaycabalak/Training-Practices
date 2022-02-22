package com.mongodb.Mongo.DB.api.controller;

import com.mongodb.Mongo.DB.business.StudentService;
import com.mongodb.Mongo.DB.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping("savestudent")
    public ResponseEntity<?> saveOneStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("getallstudents")
    public ResponseEntity<?> getAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

}
